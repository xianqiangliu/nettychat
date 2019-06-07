package com.wiseco.nettychat.nettydemo.protocol.serialize;

import com.wiseco.nettychat.nettydemo.protocol.serialize.impl.JSONSerializer;

/**
 * @author xianqiangliu
 * @date 2019/6/7 17:40
 */
public interface Serializer {

    byte JSON_SERIALIZER=1;

    Serializer DEFAULT = new JSONSerializer();

    byte getSerializerAlgorithm();

    byte[] serialize(Object object);

    <T> T deserilize(Class<T> clazz,byte[]bytes);
}
