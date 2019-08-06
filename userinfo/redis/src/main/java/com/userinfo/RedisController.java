package com.userinfo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import redis.clients.jedis.Jedis;

public class RedisController {

    //日志
    public static Log log = LogFactory.getLog(RedisController.class);
    private Jedis jedis;

    /**
     * 连接redis
     */
    public void connectRedis() {
        jedis=Connection.getJedis();
    }

    /**
     * redis写string
     */
    public void testString() {
        //增
        jedis.set("name", "localhost");
        log.info(jedis.get("name"));

        //改
        jedis.append("name", ".com");
        log.info(jedis.get("name"));

        //删
        jedis.del("name");
        log.info(jedis.get("name"));

        //设值
        jedis.mset("name","yc","age","22","qq","1933108196");
        jedis.incr("age");
        log.info(jedis.get("name") + "-" + jedis.get("age") + "-" +jedis.get("qq"));
    }


    /**
     * 使用map
     */
    public void testMap() {
        Map<String,String> map = new HashMap<String,String>();

        map.put("name", "yc");
        map.put("age", "22");
        map.put("qq", "1933108196");
        jedis.hmset("user", map);

        List<String> rsmap = jedis.hmget("user", "name","age","qq");
        log.info(rsmap);

        jedis.hdel("user", "age");
        log.info(jedis.hmget("user", "age"));//因为删除了，所以返回的是Null
        log.info(jedis.hlen("user"));//返回key为user的键中存放的值的个数2
        log.info(jedis.exists("user"));//是否存在key为user的记录，返回true
        log.info(jedis.hkeys("user"));//返回map对象中的所有key
        log.info(jedis.hvals("user"));//返回map对象中的所有value

        Iterator<String> iter = jedis.hkeys("user").iterator();
        while(iter.hasNext()) {
            String key = iter.next();
            log.info(key+":" + jedis.hmget("user", key));
        }

    }

    /**
     * 使用list
     */
    public void testList() {
        jedis.del("java framework");
        log.info(jedis.lrange("java framework", 0, -1));

        jedis.lpush("java framework","spring");
        jedis.lpush("java framework", "struts");
        jedis.lpush("java framework", "hibernate");

        log.info(jedis.lrange("java framework", 0, -1));

        jedis.del("java framework");
        jedis.rpush("java framework", "spring");
        jedis.rpush("java framework", "struts");
        jedis.rpush("java framework","hibernate");
        log.info(jedis.lrange("java framework", 0, -1));
    }

    /**
     * 使用set
     */
    public void testSet() {
        jedis.sadd("user", "liuling");
        jedis.sadd("user", "xinxin");
        jedis.sadd("user","ling");
        jedis.sadd("user", "zhangxinxin");
        jedis.sadd("user", "who");
        jedis.srem("user", "who");
        log.info(jedis.smembers("user"));
        log.info(jedis.sismember("user", "who"));
        log.info(jedis.srandmember("user"));
        log.info(jedis.scard("user"));
    }


    /**
     * redis排序
     */
    public void Sort() {
        log.info("hi");
        jedis.del("a");
        jedis.rpush("a", "1");
        jedis.lpush("a", "6");
        jedis.lpush("a", "3");
        jedis.lpush("a", "9");
        log.info(jedis.lrange("a", 0, -1));
        log.info(jedis.sort("a"));
        log.info(jedis.lrange("a", 0, -1));
    }

    /**
     * 测试
     */
    public void testRedisPool() {
        Connection.getJedis().set("newname", "test");
        log.info(Connection.getJedis().get("newname"));
    }

    public static void main(String[] args) {
        RedisController redisController=new RedisController();
        redisController.connectRedis();
        redisController.Sort();
    }
}
