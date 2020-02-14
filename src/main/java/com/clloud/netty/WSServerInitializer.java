package com.clloud.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

public class WSServerInitializer extends ChannelInitializer<SocketChannel> {
    protected void initChannel(SocketChannel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();

        // WebSocket基于HTTP协议，所以要有HTTP编解码器
        pipeline.addLast(new HttpServerCodec());
        // 对写大数据流的支持
        pipeline.addLast(new ChunkedWriteHandler());
        // 对HTTPMessage进行聚合，聚合成FullHttpRequest或者FullHttpResponse
        // 在netty中的编程，都会使用到此handler
        pipeline.addLast(new HttpObjectAggregator(1024 * 60));

        // =========================以上用于支持HTTP协议==============================

        // WebSocket 服务器处理的协议，用于指定给客户端连接访问的路由: /ws
        // 这个handler用于处理一些繁中复杂的事情，处理handshaking(close, ping, pong)
        // WebSocket通过frames来传输信息
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

        pipeline.addLast(new ChatHandler());
    }
}
