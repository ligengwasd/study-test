package com.ydb.netty.shengsiyuan.firstpackage;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author ligeng
 * @Date 19/6/24
 * @Time 下午9:37
 */
public class TestServer {
    public static void main(String[] args) {
        EventLoopGroup bossGroup = new NioEventLoopGroup();// 接收连接
        EventLoopGroup workerGroup = new NioEventLoopGroup();// 处理连接

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).
            childHandler(null);





    }
}
