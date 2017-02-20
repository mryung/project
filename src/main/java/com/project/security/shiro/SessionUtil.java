package com.project.security.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.project.entity.TbUser;

/**
 * 
 * @projectNam project
 * @classname  SessionUtil
 * @<p>description:	用来得到session相关的工具类</p>
 * @email     2327542415@qq.com
 * @date       2017年2月20日:下午3:54:49
 * @version    0.0.1
 *
 */
public class SessionUtil {
	
	static public int getUserid(){
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated()){
			TbUser user = (TbUser) subject.getPrincipal();
			return user.getUserId();
		}
		return -1; //表示没有认证的
	}
	
	static public String getUsername(){
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated()){
			TbUser user = (TbUser) subject.getPrincipal();
			return user.getNickname();
		}
		return "anyone"; //表示没有认证的
	}
	
	static public int getUserOrg(){
		
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated()){
			TbUser user = (TbUser) subject.getPrincipal();
			return user.getOrganizationId();
		}
		return -1; //表示没有认证的
	}
}
