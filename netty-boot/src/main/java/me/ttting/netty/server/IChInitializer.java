package me.ttting.netty.server;

import io.netty.channel.Channel;

/**
 * Created by titengjiang
 */
public interface IChInitializer {
    void initChannel(Channel ch) throws Exception;
}
