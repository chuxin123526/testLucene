package com.believe.testJedis;

import java.util.List;
import java.util.Set;
import java.util.concurrent.SynchronousQueue;
import org.junit.Assert;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

public class Test
{
	@org.junit.Test
	public void test() throws Exception
	{
		String host = "localhost" ; 
		JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), host) ; 
		Jedis jedis = jedisPool.getResource() ; 
		Transaction transaction = jedis.multi() ; 
		transaction.set("test", "test") ; 
		transaction.lpush("testList", "1") ; 
		transaction.lpush("testList", "1") ; 
		transaction.lpush("testList", "1") ; 
		transaction.lpush("testList", "1") ; 
		transaction.lpush("testList", "1") ; 
		transaction.lpush("testList", "1") ; 
		transaction.lpush("testList", "1") ; 
		
		Response<List<String>> list = transaction.lrange("testList", 0, 5) ; 
	    transaction.exec() ; 
	    System.out.println(list.get().size());	
		
	}
	
	@org.junit.Test
	public void testSubscribe() throws Exception
	{
		PublishListen listen = new PublishListen() ; 
		String channel = "testChannel" ; 
		
		String host = "localhost" ; 
		JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), host) ; 
		Jedis jedis = jedisPool.getResource() ; 
		jedis.subscribe(listen, channel);
		
	}
	
	@org.junit.Test
	public void testPublish() throws Exception
	{
		String host = "localhost" ; 
		JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), host) ; 
		Jedis jedis = jedisPool.getResource() ; 
		jedis.publish("testChannel", "message from testChannel") ; 
		System.out.println("end");
		jedis.close();
	}
	
}
