package com.wiseco.nettychat.nettydemo.packet;

import com.wiseco.nettychat.nettydemo.protocol.Packet;
import lombok.Data;
import static com.wiseco.nettychat.nettydemo.protocol.Command.MESSAGE_REQUEST;

/**
 * @author xianqiangliu
 * @date 2019/6/7 21:34
 */
@Data
public class MessageRequestPacket extends Packet {
    private String message;

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}
