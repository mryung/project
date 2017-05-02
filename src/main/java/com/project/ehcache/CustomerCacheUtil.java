package com.project.ehcache;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.core.io.ClassPathResource;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;



/**
 * 
 * @projectNam hisdb
 * @classname  CustomerCacheUtil
 * @<p>description: 用来缓存数据信息</p>
 * @email     2327542415@qq.com
 * @date       2017年3月7日:上午10:55:08
 * @version    0.0.1
 *
 */
public class CustomerCacheUtil {
	
	private CacheManager cacheManager;
	private String cacheManagerConfigurePath;
	private String cacheName = "datacahche";
	private Cache cache;
	
	MessageDigest md5;
	
	public CustomerCacheUtil(String cacheManagerConfigurePath) {
		ClassPathResource classPathResource = new ClassPathResource(cacheManagerConfigurePath);
		try {
			md5= MessageDigest.getInstance("MD5");
			InputStream inputStream = classPathResource.getInputStream();
			cacheManager = CacheManager.newInstance(inputStream);  
			cache = cacheManager.getCache(cacheName);
		} catch (IOException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public void writeValue(String key,Object value){
		key = Md5Hash.fromBase64String(key).toString();
		cache.put(new Element(key, value));
	}
	
	public Object getValue(String key){
		key = Md5Hash.fromBase64String(key).toString();
		Element element = cache.get(key);
		return element == null ? null : element.getObjectValue();
	}
	
	public void setKey(Long startTime,Long endTime){
		
	}
	
	public CacheManager getCacheManager() {
		return cacheManager;
	}

	

	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}


	public String getCacheManagerConfigurePath() {
		return cacheManagerConfigurePath;
	}


	public void setCacheManagerConfigurePath(String cacheManagerConfigurePath) {
		this.cacheManagerConfigurePath = cacheManagerConfigurePath;
	}
}
