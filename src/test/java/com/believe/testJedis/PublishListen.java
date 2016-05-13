package com.believe.testJedis;

import redis.clients.jedis.JedisPubSub;

public class PublishListen extends JedisPubSub
{
	public void onMessage(String channel, String message)
	{
		System.out.println(channel + message);
		System.out.println("onMessage");
	}

	public void onSubscribe(String channel, int subscribedChannels)
	{
		System.out.println(channel + subscribedChannels);
		System.out.println("onsubscribe");
	}

	public void onUnsubscribe(String channel, int subscribedChannels)
	{
		System.out.println(channel + subscribedChannels);
	}

	public void onPSubscribe(String pattern, int subscribedChannels)
	{
		System.out.println(pattern + subscribedChannels);
	}

	public void onPUnsubscribe(String pattern, int subscribedChannels)
	{
		System.out.println(pattern + subscribedChannels);
	}

	public void onPMessage(String pattern, String channel, String message)
	{
		System.out.println(channel + message);
	}
}
