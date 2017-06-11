package com.husjay.jedis;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisDemo1 {
	
	@Test
	public void demo1() {
		Jedis jedis = new Jedis("119.23.60.38", 6379);
		
		
		jedis.del("name");
		jedis.set("name", "hushaojie");
		
		System.out.println(jedis.get("name"));
		
		jedis.close();
	}
	
	/**
	 * 连接池
	 */
	@Test
	public void demo2() {
		
		//获得连接池配置
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(30);
		config.setMaxIdle(10);
		
		JedisPool jedisPool = new JedisPool(config, "119.23.60.38", 6379);
		
		Jedis jedis = null;
		
		try {
			jedis = jedisPool.getResource();
			
			jedis.set("name", "hsj");
			System.out.println(jedis.get("name"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(jedis != null) {
				jedis.close();
			}
			if(jedisPool != null) {
				jedisPool.close();
			}
		}
		
	}
	

}
