package com.wiseco.nettychat.nettydemo.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * @author xianqiangliu
 * @date 2019/6/7 15:50
 */
public class FirstServerhandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        ByteBuf byteBuf = (ByteBuf)msg;
        System.out.println(new Date()+":服务器读取数据->"+byteBuf.toString(Charset.forName("utf-8")));

        System.out.println(new Date()+": 服务端写出数据");
        ByteBuf buffer = getByteBuf(ctx);
        ctx.writeAndFlush(buffer);
    }



    private ByteBuf getByteBuf(ChannelHandlerContext ctx){
        ByteBuf buffer = ctx.alloc().buffer();
        byte[] bytes = "hello client, welcome to access me blog!".getBytes(Charset.forName("utf-8"));
        buffer.writeBytes(bytes);
        return buffer;
    }
}
