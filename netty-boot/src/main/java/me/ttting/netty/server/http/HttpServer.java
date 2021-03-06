package me.ttting.netty.server.http;

import io.netty.handler.codec.http.HttpServerCodec;
import me.ttting.netty.server.IChInitializer;
import me.ttting.netty.server.ServerConfig;
import me.ttting.netty.server.tcp.TcpServer;

/**
 * Created by titengjiang
 */
public class HttpServer  extends TcpServer{
    public HttpServer(ServerConfig serverConfig) {
        super(serverConfig, (ch) -> {
            ch.pipeline().addLast(new HttpServerCodec());
            ch.pipeline().addLast(new HttpRequestAggregator());
            serverConfig.getiChInitializer().initChannel(ch);
        });
    }
}
