package com.project.security.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SaltedAuthenticationInfo;
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
import com.project.entity.project.Right;
import com.project.entity.project.Role;
import com.project.mapper.TbUserMapper;
import com.project.mapper.project.UserRightMapper;
import com.project.mapper.project.UserRoleMapper;

public class CustomRealm extends AuthorizingRealm {

	@Autowired
	private TbUserMapper userDao;
	
	@Autowired
	private UserRoleMapper  userRoleDao;
	
	@Autowired
	private UserRightMapper userRightDao;
	
	
	
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
//		SaltedAuthenticationInfo
		SaltedAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
				user, user.getPassword(), ByteSource.Util.bytes(user.getEmail()), getName());
		return simpleAuthenticationInfo;
	}
	
	private String authorizationCacheKey = "authorizationCacheKey_user_id_name_";
	
	@Override
	protected Object getAuthorizationCacheKey(PrincipalCollection principals) {
		TbUser user  = (TbUser) principals.getPrimaryPrincipal();
		if(user == null){
			return super.getAuthorizationCacheKey(principals);
		}else{
			Integer userId = user.getUserId();
			if(userId  == null){
				return super.getAuthorizationCacheKey(principals);
			}else{
				StringBuilder key = new StringBuilder();
				key.append(authorizationCacheKey).append(userId).append("_").append(user.getUsername());
				return key.toString();
			}
		}
	}
	
	//用户授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		//根据用户id得到角色列表
		int userid = SessionUtil.getUserid();
		List<Role> userRole = userRoleDao.selectRoleByUserId(userid);
		
		List<Right> userRight = userRightDao.selectRightByUser(userid);
		
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		for (Role role : userRole) {
			authorizationInfo.addRole(role.getRoleCode());
		}
		
		for (Right right : userRight) {
			authorizationInfo.addRole(right.getRightCode());
		}
		return authorizationInfo;
	}


}
