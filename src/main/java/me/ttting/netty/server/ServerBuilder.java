package me.ttting.netty.server;

import io.netty.channel.ChannelOption;

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

    public Server build() {
        return null;
    }
}
