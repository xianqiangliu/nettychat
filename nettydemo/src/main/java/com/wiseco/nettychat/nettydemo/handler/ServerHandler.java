package com.wiseco.nettychat.nettydemo.handler;

import com.wiseco.nettychat.nettydemo.protocol.LoginRequestPacket;
import com.wiseco.nettychat.nettydemo.protocol.Packet;
import com.wiseco.nettychat.nettydemo.protocol.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * @author xianqiangliu
 * @date 2019/6/7 20:23
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg){
        ByteBuf requestBuffer = (ByteBuf) msg;
        System.out.println(new Date()+": 客户端开始登录。。。");

        Packet packet = PacketCodeC.INSTANCE.decode(requestBuffer);
        if(packet instanceof LoginRequestPacket){
           // LoginRequestPacket loginRequestPacket = (LoginRequestPacket) packet;
            LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
            loginRequestPacket.setVersion(packet.getVersion());
            if(valid(loginRequestPacket)){
                System.out.println("登录成功！");
                loginRequestPacket.setSuccess(true);
            }else{
                loginRequestPacket.setReason("账号密码校验失败！");
                loginRequestPacket.setSuccess(false);
            }

            ByteBuf responseByteBuf = PacketCodeC.INSTANCE.encode(ctx.alloc(),loginRequestPacket);
            ctx.channel().writeAndFlush(responseByteBuf);
        }


    }

    private boolean valid(LoginRequestPacket loginRequestPacket){
        return true;
    }
}
