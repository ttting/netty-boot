package me.ttting.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * Created by titengjiang
 */
public abstract class AbstractServer implements Server {
    private ServerBootstrap serverBootstrap;

    private ServerConfig serverConfig;

    private IChInitializer iChInitializer;

    public AbstractServer(ServerConfig serverConfig, IChInitializer iChInitializer) {
        this.serverConfig = serverConfig;
        this.serverBootstrap = BootStrapFactory.newServerBootStrap(serverConfig.getBossThreads(), serverConfig.getWorkerThreads(), serverConfig.getChannelType());
        initChildHandler();
        initOptions();
        initChildOptions();
    }

    private void initChildHandler() {
        serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                iChInitializer.initChannel(ch);
            }
        });
    }

    private void initOptions() {
        serverConfig.getBossOptions().entrySet().stream().forEach(entry -> serverBootstrap.option(entry.getKey(), entry.getValue()));
    }

    private void initChildOptions() {
        serverConfig.getChildOptions().entrySet().stream().forEach(entry -> serverBootstrap.childOption(entry.getKey(), entry.getValue()));
    }
}
