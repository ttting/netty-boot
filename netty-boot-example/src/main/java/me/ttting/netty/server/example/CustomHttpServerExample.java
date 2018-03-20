package me.ttting.netty.server.example;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.*;
import me.ttting.netty.server.ServerBuilder;
import me.ttting.netty.server.http.DispatcherHttpHandler;
import me.ttting.netty.server.http.OneResponseExecutor;

import java.util.List;
import java.util.Map;

/**
 * Created by titengjiang
 */
public class CustomHttpServerExample {
    public static void main(String[] args) throws InterruptedException {
        DispatcherHttpHandler dispatcherHttpHandler = new DispatcherHttpHandler();
        dispatcherHttpHandler.register("/ping", HttpMethod.GET, new PingHttpRequestExecutor());

        new ServerBuilder().setPort(8080).setiChInitializer((ch -> ch.pipeline().addLast(dispatcherHttpHandler))).build().start();
    }

    static class PingHttpRequestExecutor extends OneResponseExecutor{
        @Override
        protected FullHttpResponse handle(HttpRequest httpRequest, Map<String, List<String>> params, ByteBuf byteBuf) throws Exception {
            FullHttpResponse response;
            byte[] responseBytes = "Pong".getBytes();
            ByteBuf responseContent = Unpooled.wrappedBuffer(responseBytes);
            response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, responseContent);
            response.headers().set("Content-Length", responseBytes.length);
            return response;
        }
    }
}
