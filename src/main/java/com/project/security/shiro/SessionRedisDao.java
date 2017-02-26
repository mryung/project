package com.project.security.shiro;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class SessionRedisDao extends EnterpriseCacheSessionDAO {
	
	@Autowired
	private JedisPool jedisPoll;
	
	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = super.doCreate(session);
		Jedis resource = jedisPoll.getResource();
		resource.set(sessionId.toString().getBytes(), sessionToByte(session));
		resource.close();
        return sessionId;
	}
	
	  // 获取session
    @Override
    protected Session doReadSession(Serializable sessionId) {
        // 先从缓存中获取session，如果没有再去数据库中获取
        Session session = super.doReadSession(sessionId); 
        if(session == null){
        	Jedis resource = jedisPoll.getResource();
            byte[] bytes = resource.get(sessionId.toString().getBytes());
            if(bytes != null && bytes.length > 0){
                session = byteToSession(bytes);    
            }
            resource.close();
        }
        return session;
    }

    // 更新session的最后一次访问时间
    @Override
    protected void doUpdate(Session session) {
    	if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()) {  
            return; //如果会话过期/停止 没必要再更新了  
        }  
    	Jedis resource = jedisPoll.getResource();
    	resource.set(session.getId().toString().getBytes(), sessionToByte(session));
    	resource.close();
    }

    // 删除session
    @Override
    protected void doDelete(Session session) {
        super.doDelete(session);
        Jedis resource = jedisPoll.getResource();
        resource.del(session.getId().toString().getBytes());
        resource.close();
    }
	
	// 把session对象转化为byte保存到redis中
    public byte[] sessionToByte(Session session){
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        byte[] bytes = null;
        try {
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(session);
            bytes = bo.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
    
    // 把byte还原为session
    public Session byteToSession(byte[] bytes){
        ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
        ObjectInputStream in;
        Session session = null;
        try {
            in = new ObjectInputStream(bi);
            session = (Session) in.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return session;
    }
	
}
