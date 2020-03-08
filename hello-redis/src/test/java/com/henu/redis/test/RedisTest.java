package com.henu.redis.test;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class RedisTest {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("192.168.0.110", 6379);
        System.out.println("连接成功");
        jedis.auth("123456");
        //查看服务是否运行
        System.out.println("服务正在运行: " + jedis.ping());
        //string
        //选择数据库----0
//        System.out.println(jedis.select(0));
//        jedis.set("hello", "123456");
//        System.out.println(jedis.get("hello"));
//        //获取原来的值并设置新值
//        System.out.println(jedis.getSet("hello", "1234"));

        //选择数据库----1
        //   System.out.println(jedis.select(1));
        //list，相当于一个栈
        //jedis.del("hi");
        //上面插入一个元素
        //jedis.lpush("hi","1","2","3");
        //底部插入一个元素
        //jedis.rpush("hi","7");
        //底部弹出一个元素
        // jedis.rpop("hi");
        //在某个元素的位置替换一个元素值
        //jedis.lset("hi",2,"x");
        //对一个列表进行修剪(trim)，就是说，让列表只保留指定区间内的元素，不在指定区间之内的元素都将被删除
        //jedis.ltrim("hi", 0, -1);
        //获取列表指定范围内的元素
        //System.out.println(jedis.lrange("hi", 0, -1));

        //数据库----2
//        System.out.println(jedis.select(2));
//        //将哈希表 key 中的字段 field 的值设为 value
//        jedis.hset("hash","id","123");
//        //同时将多个 field-value (域-值)对设置到哈希表 key 中。
//        Map<String,String> map=new HashMap<>();
//        map.put("id","1");
//        map.put("name","hello");
//        jedis.hmset("hash1",map);
//        System.out.println(jedis.hvals("hash1"));
//        //获取在哈希表中指定 key 的所有字段和值
//        System.out.println(jedis.hgetAll("hash1"));
//        //获取所有哈希表中的字段
//        System.out.println(jedis.hkeys("hash1"));
//        //为哈希表 key 中的指定字段的整数值加上增量 increment
//        System.out.println(jedis.hincrBy("hash","id",10));

        //数据库----3
        System.out.println(jedis.select(3));
        jedis.sadd("set", "2");
        jedis.sadd("set", "2", "3", "4", "5");

        jedis.sadd("set1", "6", "7");
        jedis.smove("set1", "set", "6");
        jedis.smove("set1", "set", "7");
        System.out.println(jedis.smembers("set"));
        System.out.println(jedis.smembers("set1"));
        System.out.println(jedis.spop("set"));
        System.out.println(jedis.srem("set", "5"));
    }
}
