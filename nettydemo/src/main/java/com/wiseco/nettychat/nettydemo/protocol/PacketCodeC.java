package com.wiseco.nettychat.nettydemo.protocol;

import com.wiseco.nettychat.nettydemo.protocol.serialize.Serializer;
import com.wiseco.nettychat.nettydemo.protocol.serialize.impl.JSONSerializer;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import java.util.HashMap;
import java.util.Map;

import static com.wiseco.nettychat.nettydemo.protocol.Command.LOGIN_REQUEST;

/**
 * @author xianqiangliu
 * @date 2019/6/7 17:56
 */
public class PacketCodeC {
    private static final int MAGIC_NUMBER=0x12345678;
    private static final Map<Byte,Class<? extends Packet>> packetTypeMap;
    private static final Map<Byte, Serializer>serializerMap;

    static {
        packetTypeMap = new HashMap<>();
        packetTypeMap.put(LOGIN_REQUEST,LoginRequestPacket.class);

        serializerMap = new HashMap<>();
        JSONSerializer serializer = new JSONSerializer();
        serializerMap.put(serializer.getSerializerAlgorithm(),serializer);
    }


    public ByteBuf encode(Packet packet){
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.ioBuffer();
        byte[] bytes = Serializer.DEFAULT.serialize(packet);

        //编码过程
        byteBuf.writeInt(MAGIC_NUMBER);
        byteBuf.writeByte(packet.getVersion());
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlgorithm());
        byteBuf.writeByte(packet.getCommand());
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);

        return byteBuf;
    }


    public Packet decode(ByteBuf byteBuf){
        byteBuf.skipBytes(4);

        byteBuf.skipBytes(1);

        byte serializerAlgorithm = byteBuf.readByte();

        byte command = byteBuf.readByte();

        int length = byteBuf.readInt();

        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);

        Class<? extends Packet> requestType = getRequestType(command);
        Serializer serializer = getSerializer(serializerAlgorithm);
        if(requestType != null && serializer != null){
            return serializer.deserilize(requestType,bytes);
        }
        return null;
    }

    private Serializer getSerializer(byte serializeAlgorithm){
        return serializerMap.get(serializeAlgorithm);
    }

    private Class<? extends Packet> getRequestType(byte command){
        return packetTypeMap.get(command);
    }
}
