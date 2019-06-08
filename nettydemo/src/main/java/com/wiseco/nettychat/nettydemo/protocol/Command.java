package com.wiseco.nettychat.nettydemo.protocol;

/**
 * @author xianqiangliu
 * @date 2019/6/7 17:32
 */
public interface Command {
    Byte LOGIN_REQUEST=1;
    Byte LOGIN_RESPONSE=2;
    Byte MESSAGE_REQUEST=3;
    Byte MESSAGE_RESPONSE=4;
}
