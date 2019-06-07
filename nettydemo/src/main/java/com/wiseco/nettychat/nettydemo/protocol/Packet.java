package com.wiseco.nettychat.nettydemo.protocol;

import lombok.Data;

/**
 * @author xianqiangliu
 * @date 2019/6/7 17:28
 */
@Data
public abstract class Packet {
    /**
     * 协议版本
     */
    private Byte version=1;

    /**
     * 指令
     */
    public abstract Byte getCommand();
}
