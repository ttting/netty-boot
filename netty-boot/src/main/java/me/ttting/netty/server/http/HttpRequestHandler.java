package me.ttting.netty.server.http;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpRequest;

/**
 * Created by titengjiang
 */
public abstract class HttpRequestHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Object[] msgs = (Object[]) msg;
        handle(ctx, (HttpRequest) msgs[0], (ByteBuf) msgs[1]);
    }
    protected abstract void handle(ChannelHandlerContext ctx, HttpRequest httpRequest, ByteBuf byteBuf) throws Exception;

}
