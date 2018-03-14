package me.ttting.netty.server;

import io.netty.channel.ChannelOption;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by titengjiang
 */
public class ServerConfig {
    private int bossThreads;

    private int workerThreads;

    private ChannelType channelType;

    private ServerType serverType;

    private Map<ChannelOption<Object>, Object> bossOptions;

    private Map<ChannelOption<Object>, Object> childOptions;

    private IChInitializer iChInitializer;

    public ServerConfig() {
        bossOptions = new ConcurrentHashMap();
        childOptions = new ConcurrentHashMap();
    }

    public ChannelType getChannelType() {
        return channelType;
    }

    public void setChannelType(ChannelType channelType) {
        this.channelType = channelType;
    }

    public ServerType getServerType() {
        return serverType;
    }

    public void setServerType(ServerType serverType) {
        this.serverType = serverType;
    }

    public Map<ChannelOption<Object>, Object> getBossOptions() {
        return bossOptions;
    }

    public void setBossOptions(Map<ChannelOption<Object>, Object> bossOptions) {
        this.bossOptions = bossOptions;
    }

    public Map<ChannelOption<Object>, Object> getChildOptions() {
        return childOptions;
    }

    public void setChildOptions(Map<ChannelOption<Object>, Object> childOptions) {
        this.childOptions = childOptions;
    }

    public int getBossThreads() {
        return bossThreads;
    }

    public void setBossThreads(int bossThreads) {
        this.bossThreads = bossThreads;
    }

    public int getWorkerThreads() {
        return workerThreads;
    }

    public void setWorkerThreads(int workerThreads) {
        this.workerThreads = workerThreads;
    }

    public IChInitializer getiChInitializer() {
        return iChInitializer;
    }

    public void setiChInitializer(IChInitializer iChInitializer) {
        this.iChInitializer = iChInitializer;
    }
}
