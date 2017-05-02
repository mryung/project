package com.project.security.shiro;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionRedisDao extends AbstractSessionDAO {
	
	private static Logger logger = LoggerFactory.getLogger(SessionRedisDao.class);
	
	private RedisManager redisManager;
	
	private String keyPrefix = "project_shiro_session_";
	
    
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

	@Override
	public void update(Session session) throws UnknownSessionException {
		logger.debug("更新session.....................");
    	if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()) {  
            return; //如果会话过期/停止 没必要再更新了  
        }  
    	Object sessionId = session.getId();
		redisManager.set(this.getByteKey(sessionId .toString()), SerializeUtils.serialize(session));
    
		
	}

	@Override
	public void delete(Session session) {
		logger.debug("删除session.....................");
    	if(session == null || session.getId() == null){
			logger.error("session or session id is null");
			return;
		}
		redisManager.del(this.getByteKey(session.getId()));
		
	}

	@Override
	public Collection<Session> getActiveSessions() {
		List<Session> values = redisManager.values("*");
		return values;
	}

	@Override
	protected Serializable doCreate(Session session) {
		logger.debug("生成session.....................");
		Serializable sessionId = this.generateSessionId(session);
		this.assignSessionId(session, sessionId);
		redisManager.set(getByteKey(sessionId.toString()), SerializeUtils.serialize(session));
        return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		logger.debug("读session.....................");
    	if(sessionId == null){
    		return null;
    	}
    	Session s = (Session)SerializeUtils.deserialize(redisManager.get(this.getByteKey(sessionId)));
    	return s;
	}
	
}
