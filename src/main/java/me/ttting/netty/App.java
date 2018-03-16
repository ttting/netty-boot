package me.ttting.netty;

import me.ttting.netty.server.ServerBuilder;
import me.ttting.netty.server.http.DispatcherHttpHandler;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        new ServerBuilder().setPort(8080).setiChInitializer((ch -> { ch.pipeline().addLast(new DispatcherHttpHandler());} )).build().start();
    }
}
