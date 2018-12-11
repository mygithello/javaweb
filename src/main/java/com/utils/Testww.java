package com.utils;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class Testww {


    @Test
    public void testddP(){

        System.out.println("================");
        Jedis jedis =JedisUtil.getJedis();
        String str =jedis.get("rev_xcb_gjjtggxxpttoken");
        System.out.println("----------:"+str);
    }
}
