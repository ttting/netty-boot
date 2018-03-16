package me.ttting.netty.server.example;

import me.ttting.netty.server.ServerBuilder;
import me.ttting.netty.server.http.DispatcherHttpHandler;

/**
 * Created by titengjiang
 */
public class DefaultHttpServerExample {
    public static void main(String[] args) throws InterruptedException {
        new ServerBuilder().setPort(8080).setiChInitializer((ch -> { ch.pipeline().addLast(new DispatcherHttpHandler());} )).build().start();
    }
}
