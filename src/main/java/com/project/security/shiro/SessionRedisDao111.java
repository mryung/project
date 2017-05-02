package com.project.security.shiro;

import java.io.Serializable;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionRedisDao111 extends EnterpriseCacheSessionDAO {
	
	private static Logger logger = LoggerFactory.getLogger(SessionRedisDao111.class);
	
	private RedisManager redisManager;
	
	private String keyPrefix = "project_shiro_session_";
	
	
	@Override
	protected Serializable doCreate(Session session) {
		logger.debug("生成session.....................");
		Serializable sessionId = super.doCreate(session);
		redisManager.set(getByteKey(sessionId.toString()), SerializeUtils.serialize(session));
        return sessionId;
	}
	
	  // 获取session
    @Override
    protected Session doReadSession(Serializable sessionId) {
    	logger.debug("读session.....................");
    	if(sessionId == null){
    		return null;
    	}
    	Session s = (Session)SerializeUtils.deserialize(redisManager.get(this.getByteKey(sessionId)));
    	return s;
    }

    // 更新session的最后一次访问时间
    @Override
    protected void doUpdate(Session session) {
    	logger.debug("更新session.....................");
    	if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()) {  
            return; //如果会话过期/停止 没必要再更新了  
        }  
    	
    	Object sessionId = session.getId();
		redisManager.set(this.getByteKey(sessionId .toString()), SerializeUtils.serialize(session));
    }

    // 删除session
    @Override
    protected void doDelete(Session session) {
    	logger.debug("删除session.....................");
    	if(session == null || session.getId() == null){
			logger.error("session or session id is null");
			return;
		}
		redisManager.del(this.getByteKey(session.getId()));
    }
    
    /**
	 * 获得byte[]型的key
	 * @param key
	 * @return
	 */
	private byte[] getByteKey(Serializable sessionId){
		String preKey = this.keyPrefix + sessionId;
		return preKey.getBytes();
	}

	public RedisManager getRedisManager() {
		return redisManager;
	}

	public void setRedisManager(RedisManager redisManager) {
		this.redisManager = redisManager;
	}

	public String getKeyPrefix() {
		return keyPrefix;
	}

	public void setKeyPrefix(String keyPrefix) {
		this.keyPrefix = keyPrefix;
	}
	
}
