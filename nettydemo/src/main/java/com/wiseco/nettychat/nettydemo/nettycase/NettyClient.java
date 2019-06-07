package com.wiseco.nettychat.nettydemo.nettycase;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Date;

/**
 * @author xianqiangliu
 * @date 2019/6/7 11:56
 */
public class NettyClient {
    public static void main(String[] args) throws Exception  {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();

        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel){
                        channel.pipeline().addLast(new StringEncoder());

                    }
                });
        Channel channel = bootstrap.connect("127.0.0.1",8888).channel();
        while(true){
            channel.writeAndFlush(new Date()+": hello world");
            Thread.sleep(2000);
        }
    }
}
