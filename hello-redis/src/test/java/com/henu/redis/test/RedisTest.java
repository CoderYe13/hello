package com.henu.redis.test;

import com.henu.redis.util.RedisPoolUtil;

public class RedisTest {
    public static void main(String[] args) {
//        //连接本地的 Redis 服务
//        Jedis jedis = new Jedis("192.168.0.110",6379);
//        System.out.println("连接成功");
//        //查看服务是否运行
//        System.out.println("服务正在运行: "+jedis.ping());
//        jedis.set("hello","123456");
//        System.out.println(jedis.get("hello"));

        System.out.println(RedisPoolUtil.get("hello"));
    }
}
