package com.xmmems.common.utils;

import java.util.HashMap;

/**
 * @描述
 * @创建人 ithxw
 * @创建时间 2021.07.22 10:59
 */
public class XmRedis {
    private static final HashMap<String, StorageValue> REDIS = new HashMap<>();

    /**
     * 有时效保存常用值
     *
     * @param key    常用值唯一标识
     * @param data   常用数据
     * @param expire 保存有效期（单位毫秒）
     */
    public static void put(String key, Object data, Long expire) {
        StorageValue temp = new StorageValue(data, expire);
        synchronized (REDIS) {
            //这里是添加或者替换
            REDIS.put(key, temp);
        }
    }

    /**
     * 几乎永久保存
     *
     * @param key  常用值唯一标识
     * @param data 常用数据
     */
    public static void put(String key, Object data) {
        StorageValue temp = new StorageValue(data);
        synchronized (REDIS) {
            //这里是添加或者替换
            REDIS.put(key, temp);
        }
    }

    /**
     * 有时效保存常用值
     *
     * @param key       常用值唯一标识
     * @param data      常用数据
     * @param expire    保存有效期
     * @param redisEnum 单位 HOUR 小时 MINUTE 分钟 SECOND 秒
     */
    public static void put(String key, Object data, Long expire, XmRedisEnum redisEnum) {
        switch (redisEnum) {
            case HOUR:
                expire = expire * 60 * 60 * 1000;
                break;
            case MINUTE:
                expire = expire * 60 * 1000;
                break;
            case SECOND:
                expire = expire * 1000;
        }
        StorageValue temp = new StorageValue(data, expire);
        synchronized (REDIS) {
            //这里是添加或者替换
            REDIS.put(key, temp);
        }
    }

    public static Object get(String key) {

        StorageValue storageValue = REDIS.get(key);
        if (storageValue == null) {
            return null;
        }
        //判断是否过期，过期则返回null 并且移除数据
        if (System.currentTimeMillis() - storageValue.getStorage() > storageValue.getExpire()) {
            synchronized (REDIS) {
                storageValue = REDIS.get(key);
                if (storageValue != null) {
                    REDIS.remove(key);
                }
            }
            return null;
        }
        return storageValue.getData();

    }

    //数据库有添加数据时或修改数据时可以用
    public static void remove(String key){
        REDIS.remove(key);
    }
    //批量删除
    public static void removeStartsWith(String keyPre){
        REDIS.entrySet().removeIf(next -> next.getKey().startsWith(keyPre));
    }

    /**
     * 存储数据的实体类
     */
    private static class StorageValue {
        //存储数据的当前时间
        private Long storage = System.currentTimeMillis();
        //存储的数据
        private Object data;
        //有效时长（单位毫秒）
        private Long expire;

        /**
         * 保存数据
         *
         * @param data   保存的数据
         * @param expire 有效期（单位毫秒）
         */
        StorageValue(Object data, Long expire) {
            this.data = data;
            this.expire = expire;
        }

        //Long expire = Long.MAX_VALUE; 有效期等于Long最大值，相当于永久保存
        StorageValue(Object data) {
            this.data = data;
            this.expire = Long.MAX_VALUE;
        }

        Long getStorage() {
            return storage;
        }

        public Object getData() {
            return data;
        }

        Long getExpire() {
            return expire;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }

}
