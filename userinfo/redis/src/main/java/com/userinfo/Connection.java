package com.userinfo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 连接redis pool
 */
public class Connection {
    //参数
    private static String ADDR = "192.168.153.133";
    private static int PORT = 6379;
    private static String AUTH = "Gao20040701";
    private static int MAX_ACTIVE = 1024;
    private static int MAX_IDLE = 200;
    private static int MAX_WAIT = 10000;
    private static int TIMEOUT = 10000;
    private static boolean TEST_ON_BORROW = true;
    private static JedisPool jedisPool = null;

    public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(MAX_ACTIVE);
        config.setMaxIdle(MAX_IDLE);
        config.setMaxWaitMillis(MAX_WAIT);
        config.setTestOnBorrow(TEST_ON_BORROW);
        jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);
        RedisController.main(args);
    }

    /**
     * 返回jedis
     * @return jedis
     */
    public synchronized static Jedis getJedis() {
            if (jedisPool != null) {
                Jedis resource = jedisPool.getResource();
                return resource;
            } else {
                return null;
            }
    }

    /**
     * 将jedis删除
     * @param jedis
     */
    public static void returnResource(final Jedis jedis) {
        if(jedis != null)jedisPool.returnResource(jedis);
    }
}
