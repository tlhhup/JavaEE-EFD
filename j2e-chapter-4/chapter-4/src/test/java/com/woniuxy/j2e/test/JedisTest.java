package com.woniuxy.j2e.test;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class JedisTest {

	@Test
	public void connection(){
		Jedis jedis=new Jedis("localhost");
		System.out.println(jedis.ping());
		jedis.close();
	}

	@Test
	public void addStr(){
		Jedis jedis=new Jedis("localhost");
		jedis.set("s1", "test");
		
		jedis.close();
	}
	
@Test
public void getStr(){
	Jedis jedis=new Jedis("localhost");
	String s1 = jedis.get("s1");
	
	System.out.println(s1);
	
	jedis.close();
}
	
}
