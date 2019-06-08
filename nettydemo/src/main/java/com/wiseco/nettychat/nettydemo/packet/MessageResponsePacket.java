package com.wiseco.nettychat.nettydemo.packet;

import com.wiseco.nettychat.nettydemo.protocol.Packet;
import lombok.Data;
import static com.wiseco.nettychat.nettydemo.protocol.Command.MESSAGE_RESPONSE;

/**
 * @author xianqiangliu
 * @date 2019/6/7 21:35
 */
@Data
public class MessageResponsePacket extends Packet {
    private String message;

    @Override
    public Byte getCommand() {
        return MESSAGE_RESPONSE;
    }
}
