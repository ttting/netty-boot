package me.ttting.netty.server.tcp;

import me.ttting.netty.server.AbstractServer;
import me.ttting.netty.server.IChInitializer;
import me.ttting.netty.server.ServerConfig;

/**
 * Created by titengjiang
 */
public class TcpServer extends AbstractServer {

    public TcpServer(ServerConfig serverConfig, IChInitializer iChInitializer) {
        super(serverConfig, iChInitializer);
    }

}
