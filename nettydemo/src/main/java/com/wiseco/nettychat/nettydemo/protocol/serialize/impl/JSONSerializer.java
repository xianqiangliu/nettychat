package com.wiseco.nettychat.nettydemo.protocol.serialize.impl;


import com.alibaba.fastjson.JSON;
import com.wiseco.nettychat.nettydemo.protocol.serialize.Serializer;
import com.wiseco.nettychat.nettydemo.protocol.serialize.SerializerAlgorithm;

/**
 * @author xianqiangliu
 * @date 2019/6/7 17:46
 */
public class JSONSerializer implements Serializer {
    @Override
    public byte getSerializerAlgorithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {

        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {

        return JSON.parseObject(bytes, clazz);
    }
}
