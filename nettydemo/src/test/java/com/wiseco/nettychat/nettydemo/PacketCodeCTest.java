package com.wiseco.nettychat.nettydemo;

import com.wiseco.nettychat.nettydemo.protocol.LoginRequestPacket;
import com.wiseco.nettychat.nettydemo.protocol.Packet;
import com.wiseco.nettychat.nettydemo.protocol.PacketCodeC;
import com.wiseco.nettychat.nettydemo.protocol.serialize.Serializer;
import com.wiseco.nettychat.nettydemo.protocol.serialize.impl.JSONSerializer;
import io.netty.buffer.ByteBuf;
import org.junit.Assert;
import org.junit.Test;


/**
 * @author xianqiangliu
 * @date 2019/6/7 18:24
 */
public class PacketCodeCTest {
    @Test
    public void encode() {

        Serializer serializer = new JSONSerializer();
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();

        loginRequestPacket.setVersion(((byte) 1));
        loginRequestPacket.setUserId("123");
        loginRequestPacket.setUsername("zhangsan");
        loginRequestPacket.setPassword("password");

        PacketCodeC packetCodeC = new PacketCodeC();
        ByteBuf byteBuf = packetCodeC.encode(loginRequestPacket);
        Packet decodedPacket = packetCodeC.decode(byteBuf);

        Assert.assertArrayEquals(serializer.serialize(loginRequestPacket), serializer.serialize(decodedPacket));

    }

}
