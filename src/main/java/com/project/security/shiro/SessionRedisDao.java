package com.project.security.shiro;

import java.io.Serializable;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;

public class SessionRedisDao extends EnterpriseCacheSessionDAO {
	
	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = super.doCreate(session);
//        RedisDb.setObject(sessionId.toString().getBytes(), sessionToByte(session));
        
        return sessionId;
	}
	
}
