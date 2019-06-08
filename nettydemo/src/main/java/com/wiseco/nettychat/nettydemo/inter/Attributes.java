package com.wiseco.nettychat.nettydemo.inter;

import io.netty.util.AttributeKey;

/**
 * @author xianqiangliu
 * @date 2019/6/7 21:42
 */
public interface Attributes {
    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
}
