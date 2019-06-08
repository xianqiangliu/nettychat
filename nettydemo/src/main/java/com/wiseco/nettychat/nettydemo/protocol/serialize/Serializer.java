package com.wiseco.nettychat.nettydemo.protocol.serialize;

import com.wiseco.nettychat.nettydemo.protocol.serialize.impl.JSONSerializer;

/**
 * @author xianqiangliu
 * @date 2019/6/7 17:40
 */
public interface Serializer {


    Serializer DEFAULT = new JSONSerializer();

    /**
     * 序列化算法
     * @return
     */
    byte getSerializerAlgorithm();

    /**
     * java 对象转换成二进制
     */
    byte[] serialize(Object object);

    /**
     * 二进制转换成 java 对象
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);
}
