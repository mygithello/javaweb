package com.utils;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisUtil {
    private static JedisPool pool =null;
    static {
       try{
           //连接池的配置信息最大连接数，最大空闲数，最小等待数
           GenericObjectPoolConfig poolConfig =new GenericObjectPoolConfig();

           //设置对应的参数

           poolConfig.setMaxTotal(100);
           poolConfig.setMaxIdle(10);

           //redis的主机地址
           String host ="192.168.10.49";

           //连接池对象
           pool =new JedisPool(poolConfig,host);
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    /**
     * 获取jedis对象的方法
     */
    public static Jedis getJedis(){
        //获取一个连接对象Jedis
        Jedis jedis =null;
        if(pool!=null){
            jedis=pool.getResource();
        }
        return jedis;
    }

    /**
     * 关闭jedis对象的方法
     */
    public static void closeJedis(Jedis jedis){
        if (jedis!=null){
            jedis.close();
        }
    }
}
