package com.project.security.shiro;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Protocol;

public class CustomJedisPool extends JedisPool {
	public CustomJedisPool(final GenericObjectPoolConfig poolConfig, final String host, int port,
		      int database) {
		super(poolConfig, host, port, Protocol.DEFAULT_TIMEOUT, null,
				database, null);
	}
	
	public CustomJedisPool(final GenericObjectPoolConfig poolConfig, final String host, int port,int timeout,
		      int database) {
		super(poolConfig, host, port, timeout, null, database);
	}
	public CustomJedisPool(final GenericObjectPoolConfig poolConfig, final String host, int port,
		      int timeout, final String password,int database) {
		    super(poolConfig, host, port, timeout, password, database, null);
		  }
}
