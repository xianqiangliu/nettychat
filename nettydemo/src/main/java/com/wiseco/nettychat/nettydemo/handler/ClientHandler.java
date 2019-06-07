package com.wiseco.nettychat.nettydemo.handler;

import com.wiseco.nettychat.nettydemo.protocol.LoginRequestPacket;
import com.wiseco.nettychat.nettydemo.protocol.Packet;
import com.wiseco.nettychat.nettydemo.protocol.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.lang.management.LockInfo;
import java.util.Date;
import java.util.UUID;

/**
 * @author xianqiangliu
 * @date 2019/6/7 20:22
 */
public class ClientHandler extends ChannelInboundHandlerAdapter{
    @Override
    public void channelActive(ChannelHandlerContext ctx){
        System.out.println(new Date()+": 客户端开始登录！");
        LoginRequestPacket lrp = new LoginRequestPacket();
        lrp.setUserId(UUID.randomUUID().toString());
        lrp.setUsername("shawn");
        lrp.setPassword("pwd");


        ByteBuf buffer = PacketCodeC.INSTANCE.encode(ctx.alloc(),lrp);

        ctx.channel().writeAndFlush(buffer);
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg){
        ByteBuf clientBuf = (ByteBuf)msg;

        Packet packet = PacketCodeC.INSTANCE.decode(clientBuf);
        if(packet instanceof LoginRequestPacket){
            LoginRequestPacket lrp = (LoginRequestPacket) packet;
            if(lrp.isSuccess()){
                System.out.println(new Date()+": 客户端登陆成功!");
            }else{
                System.out.println(new Date()+"; 客户端登录失败，原因是："+lrp.getReason());
            }
        }
    }

}
