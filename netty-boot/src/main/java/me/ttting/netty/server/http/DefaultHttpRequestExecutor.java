package me.ttting.netty.server.http;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFutureListener;
import io.netty.handler.codec.http.*;

import java.util.List;
import java.util.Map;

/**
 * Created by titengjiang
 */
public class DefaultHttpRequestExecutor extends OneResponseExecutor {
    public static final HttpResponseStatus DEFAULT_STATUS = HttpResponseStatus.NOT_FOUND;

    @Override
    protected FullHttpResponse handle(HttpRequest httpRequest, Map<String, List<String>> params, ByteBuf byteBuf) throws Exception {
        FullHttpResponse response;
        response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, DEFAULT_STATUS);
        response.headers().set("Content-Length", Integer.valueOf(0));
        return response;
    }
}
