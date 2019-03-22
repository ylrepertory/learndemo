package com.leo.learn.netty.helloworld.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @program: learndemo
 * @description:
 * @author: leo
 * @create: 2019-03-21 16:41
 **/
public final class NIOServer {
    public  static void main(String[] args) throws Exception {

        // 创建 ServerBootstrap 对象
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        //创建两个EventLoopGroup对象
        //创建boss线程组 用于服务端接受客户端的连接
        NioEventLoopGroup boos = new NioEventLoopGroup();
        // 创建 worker 线程组 用于进行 SocketChannel 的数据读写
        NioEventLoopGroup worker = new NioEventLoopGroup();
        //设置使用的EventLoopGroup
        serverBootstrap
                .group(boos, worker)
                //设置要被实例化的为 NioServerSocketChannel 类
                .channel(NioServerSocketChannel.class)
                // 设置连入服务端的 Client 的 SocketChannel 的处理器
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    protected void initChannel(NioSocketChannel ch) {
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                            @Override
                            protected void channelRead0(ChannelHandlerContext ctx, String msg) {
                                System.out.println(msg);
                            }
                        });
                    }
                })
                // 绑定端口，并同步等待成功，即启动服务端
                .bind(8000);
    }
}
