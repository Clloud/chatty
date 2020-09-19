package com.clloud.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.stereotype.Component;

@Component
public class WSServer {
    private static class SingletonWSServer {
        private static final WSServer INSTANCE = new WSServer();
    }

    public static WSServer getInstance() {
        return SingletonWSServer.INSTANCE;
    }

    private EventLoopGroup mainGroup;
    private EventLoopGroup subGroup;
    private ServerBootstrap server;
    private ChannelFuture future;

    private WSServer() {
        // 定义主从线程组
        mainGroup = new NioEventLoopGroup();
        subGroup = new NioEventLoopGroup();
        // 设置启动类
        server = new ServerBootstrap();
        server.group(mainGroup, subGroup)                   // 设置主从线程组
                .channel(NioServerSocketChannel.class)      // 设置NIO双向通道
                .childHandler(new WSServerInitializer());   // 设置子处理器，用于处理subGroup
    }

    public void start() {
        this.future = server.bind(8088);
        System.err.println("Netty web socket server start...");
    }

    public void close() {
    }
}
