package com.wiseco.nettychat.nettydemo.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/**
 * @author xianqiangliu
 * @date 2019/6/7 16:44
 */
public class ByteBufTest {
    public static void main(String[] args) {
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(9, 100);
        print("allocat ByteBuf(9,100)",buffer);

        buffer.writeBytes(new byte[]{1,2,3,4});
        print("writeBytes(1,2,3,4)",buffer);

        buffer.writeInt(12);
        print("writeInt(12)",buffer);

        buffer.writeBytes(new byte[]{5});
        print("wirteBytes(5)",buffer);

        buffer.writeBytes(new byte[]{6});
        print("writeBytes(6)",buffer);


        System.out.println("getByte(3) return: " + buffer.getByte(3));
        System.out.println("getShort(3)return: " + buffer.getShort(3));
        System.out.println("getInt(3)return: " + buffer.getInt(3));
        print("getByte()",buffer);

        buffer.setByte(buffer.readableBytes()+1,0);
        print("setByte()",buffer);

        byte[] dst = new byte[buffer.readableBytes()];
        buffer.readBytes(dst);
        print("readBytes("+dst.length+")",buffer);
    }
    private static void print(String action, ByteBuf byteBuf){
        System.out.println("after==========="+action+"=========");
        System.out.println("capacity(): " + byteBuf.capacity());
        System.out.println("maxCapacity(): "+byteBuf.maxCapacity());
        System.out.println("readerIndex(): " + byteBuf.readerIndex());
        System.out.println("readableBytes(): "+byteBuf.readableBytes());
        System.out.println("isReadable(): " + byteBuf.isReadable());
        System.out.println("writerIndex(): "+byteBuf.writerIndex());
        System.out.println("writableBytes(): " +byteBuf.writableBytes());
        System.out.println("isWritable(): " + byteBuf.isWritable());
        System.out.println("maxWritableBytes(): " +byteBuf.maxWritableBytes());
        System.out.println();
    }
}
