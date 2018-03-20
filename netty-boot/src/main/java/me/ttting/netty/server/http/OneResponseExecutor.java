package me.ttting.netty.server.http;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpRequest;

import java.util.List;
import java.util.Map;

/**
 * Created by titengjiang
 */
public abstract class OneResponseExecutor implements HttpRequestExecutor {
    @Override
    public void handle(ChannelHandlerContext ctx, HttpRequest httpRequest, Map<String, List<String>> params, ByteBuf byteBuf) throws Exception {
        FullHttpResponse response = handle(httpRequest, params, byteBuf);

        if (HttpHeaders.isKeepAlive(httpRequest)) {
            response.headers().set(HttpHeaders.Names.CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
        }

        ChannelFuture future = ctx.writeAndFlush(response);
        if (!HttpHeaders.isKeepAlive(httpRequest)) {
            future.sync();
            ctx.close();
        }
    }

    protected abstract FullHttpResponse handle(HttpRequest httpRequest, Map<String, List<String>> params, ByteBuf byteBuf) throws Exception;

}
