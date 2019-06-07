package com.wiseco.nettychat.nettydemo.protocol;

import lombok.Data;

import static com.wiseco.nettychat.nettydemo.protocol.Command.LOGIN_REQUEST;

/**
 * @author xianqiangliu
 * @date 2019/6/7 17:33
 */
@Data
public class LoginRequestPacket extends Packet {
    private String userId;

    private String username;

    private String password;

    private String reason;

    private boolean success;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}