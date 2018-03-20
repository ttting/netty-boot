package me.ttting.netty.server.http;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpRequest;

import java.util.List;
import java.util.Map;

/**
 * Created by titengjiang
 */
public interface HttpRequestExecutor {
    void handle(ChannelHandlerContext ctx, HttpRequest httpRequest, Map<String, List<String>> params, ByteBuf byteBuf) throws Exception;
}
