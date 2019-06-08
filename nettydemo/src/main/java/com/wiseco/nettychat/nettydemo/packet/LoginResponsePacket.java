package com.wiseco.nettychat.nettydemo.packet;

import com.wiseco.nettychat.nettydemo.protocol.Packet;
import lombok.Data;
import static com.wiseco.nettychat.nettydemo.protocol.Command.LOGIN_RESPONSE;

/**
 * @author xianqiangliu
 * @date 2019/6/7 22:23
 */
@Data
public class LoginResponsePacket extends Packet {
    private boolean success;
    private String reason;
    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}
