package com.tpms.utils;

import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * redis工具类
 */
public final class RedisUtils {
    private static RedisUtils redisUtils = new RedisUtils();
    private static String url;
    private static String password;
    private static Jedis jedis;

    static {
        InputStream in = RedisUtils.class.getResourceAsStream("/redis.properties");
        Properties prop = new Properties();
        try {
            prop.load(in);
            url = prop.getProperty("url");
            password = prop.getProperty("password");
            jedis = new Jedis(url);
            jedis.auth(password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private RedisUtils() {}

    /**
     * @return 获取RedisUtils实例
     */
    public static RedisUtils getInstance() {
        return redisUtils;
    }

    /**
     * 检测redis是否已连接
     */
    public void check() {
        if ("PONG".equals(jedis.ping())) {
            return;
        }
        throw new RuntimeException(url + "not connection");
    }

    /************************** String Type Begin *****************************************/
    /**
     * 设置key-value
     * 
     * @param key 要保存的键
     * @param value 要保存到值
     */
    public void setString(String key, String value) {
        check();
        jedis.set(key, value);
    }

    /**
     * 设置key-value，同时设置过期时间
     * 
     * @param key 要保存的键
     * @param value 要保存到值
     * @param expire 过期时间，单位:秒
     */
    public void setString(String key, String value, int expire) {
        setString(key, value);
        jedis.expire(key, expire);
    }

    /**
     * 根据key获取对应的值
     * 
     * @param key 键
     * @return 键对应的值
     */
    public String getString(String key) {
        check();
        return jedis.get(key);
    }

    /************************** String Type END *****************************************/

    /************************** List Type BEGIN ****************************************/
    /**
     * 设置list到redis中
     * 
     * @param key list对应的键
     * @param list 集合
     */
    public void setList(String key, List<String> list) {
        check();
        if (list == null) {
            throw new RuntimeException("list is null , please check");
        }
        if (list.size() == 0) {
            throw new RuntimeException("list not have data , please check");
        }
        for (int i = 0, len = list.size(); i < len; i++) {
            jedis.lpush(key, list.get(i));
        }
    }

    /**
     * 获取集合列表
     * 
     * @param key 键
     * @return 集合
     */
    public List<String> getList(String key) {
        return jedis.lrange(key, 0, sizeList(key));
    }

    /**
     * key对应的集合中是否存在value
     * 
     * @param key 键
     * @param value 值
     * @return 集合
     */
    public boolean existList(String key, String value) {
        if (value == null || "".equals(value)) {
            return false;
        }
        List<String> list = getList(key);
        if (list == null) {
            return false;
        }
        for (int i = 0, len = list.size(); i < len; i++) {
            if (value.equals(list.get(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取集合大小
     * 
     * @param key 键
     * @return 集合大小|长度
     */
    public Long sizeList(String key) {
        return jedis.llen(key);
    }

    /**
     * 删除key对应的集合
     * 
     * @param key 键
     */
    public void delList(String key) {
        jedis.expire(key, 0);
    }

    /************************** List Type END *****************************************/

    /************************** Redis System Operation BEGIN ****************************************/

    /************************** Redis System Operation END *****************************************/

    public static void main(String[] args) throws InterruptedException {
        RedisUtils ru = RedisUtils.getInstance();
        /*
         * ru.setString("a","10"); ru.setString("b","20",5); System.out.println(ru.getString("b"));
         * System.out.println(ru.getString("a")); Thread.sleep(5000); System.out.println(ru.getString("b"));
         * System.out.println(ru.getString("a"));
         */
        String key = "list";
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 26; i++) {
            list.add(String.valueOf((char) (i + 97)));
        }
        ru.delList(key);
        ru.setList(key, list);
        List<String> ruList = ru.getList(key);
        for (int i = ruList.size() - 1; i >= 0; i--) {
            System.out.print(ruList.get(i) + " ");
        }
        System.out.println();
        System.out.println(ru.existList(key, "B"));
    }
}
