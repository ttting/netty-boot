package me.ttting.netty.server;

import io.netty.channel.ChannelOption;
import me.ttting.netty.server.http.HttpServer;
import me.ttting.netty.server.tcp.TcpServer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by titengjiang
 */
public class ServerBuilder {
    private ServerConfig serverConfig;

    public ServerBuilder() {
        serverConfig = new ServerConfig();
    }

    public ServerBuilder setChannelType(ChannelType type) {
        this.serverConfig.setChannelType(type);
        return this;
    }

    public ServerBuilder setServerType(ServerType serverType) {
        this.serverConfig.setServerType(serverType);
        return this;
    }

    public ServerBuilder setBossChannelOptions(Map<ChannelOption<Object>,Object> channelOptions) {
        this.serverConfig.getBossOptions().putAll(channelOptions);
        return this;
    }

    public <T> ServerBuilder setBossChannelOption(ChannelOption<Object> option, T value) {
        this.serverConfig.getBossOptions().put(option, value);
        return this;
    }

    public ServerBuilder setChildChannelOptions(Map<ChannelOption<Object>, Object> channelOptions) {
        this.serverConfig.getChildOptions().putAll(channelOptions);
        return this;
    }

    public <T> ServerBuilder setChildChannelOption(ChannelOption<Object> option, T value) {
        this.serverConfig.getChildOptions().put(option, value);
        return this;
    }

    public ServerBuilder setiChInitializer(IChInitializer iChInitializer) {
        this.serverConfig.setiChInitializer(iChInitializer);
        return this;
    }

    public ServerBuilder setPort(int port) {
        this.serverConfig.setPort(port);
        return this;
    }

    public ServerBuilder setHost(String host) {
        this.serverConfig.setHost(host);
        return this;
    }

    public Server build() {
        switch (serverConfig.getServerType()) {
            case TCP: {
                return new TcpServer(serverConfig, serverConfig.getiChInitializer());
            }
            case HTTP: {
                return new HttpServer(serverConfig);
            }
            default:
                throw new RuntimeException("UnSupport ServerType");
        }
    }
}
