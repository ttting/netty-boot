package me.ttting.netty.server.http;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;

/**
 * Created by titengjiang
 */
public class DispatcherHttpHandler extends HttpRequestHandler {
    private PatternRegister patternRegister = new DefaultPatternRegister();

    private HttpRequestExecutor defaultExecutor;

    public DispatcherHttpHandler() {}

    public void register(String urlPattern, HttpMethod method, HttpRequestExecutor executor) {
        patternRegister.register(urlPattern, method, executor);
    }

    @Override
    protected void handle(ChannelHandlerContext ctx, HttpRequest httpRequest, ByteBuf byteBuf) throws Exception {
        QueryStringDecoder queryDecoder = new QueryStringDecoder(httpRequest.getUri());
        HttpRequestExecutor executor = patternRegister.getRequestHandler(queryDecoder.path(), httpRequest.getMethod());
        if (executor == null)  executor = defaultExecutor;
        executor.handle(ctx, httpRequest, queryDecoder.parameters(), byteBuf);
    }
}
