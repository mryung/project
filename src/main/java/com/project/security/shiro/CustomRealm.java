package com.project.security.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.entity.TbUser;
import com.project.entity.TbUserExample;
import com.project.entity.TbUserExample.Criteria;
import com.project.mapper.TbUserMapper;

public class CustomRealm extends AuthorizingRealm {

	@Autowired
	private TbUserMapper userDao;
	
	@Override
	public boolean supports(AuthenticationToken token) {
		
		return (token instanceof UsernamePasswordToken);
	}
	
	//用户认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		/// 从token中 获取用户身份信息
		String username = (String) token.getPrincipal();
		
		TbUserExample condition = new TbUserExample();
		Criteria emailCrieria = condition.createCriteria();
		Criteria phoneCrieria = condition.or();
		emailCrieria.andEmailEqualTo(username);
		phoneCrieria.andPhoneEqualTo(username);
		List<TbUser> example = userDao.selectByExample(condition);
		if(example.size() == 0 || example.size() > 1){
			return  null;
		}
		TbUser user = example.get(0);
		// 获取从数据库查询出来的用户密码
	
		// 返回认证信息由父类AuthenticatingRealm进行认证
		
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
				user, user.getPassword(), ByteSource.Util.bytes(user.getEmail()), getName());
		return simpleAuthenticationInfo;
	}
	
	
	//用户授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.addRole("sys:role");
		
		return authorizationInfo;
	}


}
