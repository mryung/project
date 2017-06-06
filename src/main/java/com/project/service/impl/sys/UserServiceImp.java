package com.project.service.impl.sys;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.myproject.message.PageInfo;
import com.myproject.message.Pageable;
import com.myproject.message.R;
import com.myproject.util.PassWordUtil;
import com.project.entity.TbUser;
import com.project.entity.TbUserExample;
import com.project.entity.TbUserRight;
import com.project.entity.TbUserRole;
import com.project.entity.TbUserExample.Criteria;
import com.project.entity.project.Right;
import com.project.entity.project.Role;
import com.project.entity.project.User;
import com.project.mapper.TbUserMapper;
import com.project.mapper.TbUserRightMapper;
import com.project.mapper.TbUserRoleMapper;
import com.project.mapper.project.UserMapper;
import com.project.mapper.project.UserRightMapper;
import com.project.mapper.project.UserRoleMapper;
import com.project.security.shiro.RedisManager;
import com.project.security.shiro.SessionUtil;
import com.project.service.UserService;

@Service
public class UserServiceImp implements UserService {


	@Autowired
	private TbUserMapper userDao;

	@Autowired
	private UserMapper userMaperDao;

	@Autowired
	private TbUserRoleMapper tbuserRoleMapper;

	@Autowired
	private TbUserRightMapper tbUserRightMapper;

	@Autowired
	private UserRightMapper userRightDao;

	@Autowired
	private UserRoleMapper userRoleDao;

	@Autowired
	@Qualifier("cacheRedisManager")
	private RedisManager cacheRedisManger;
	
	@Deprecated
	@Override
	public PageInfo<TbUser> listUser(int page, int pageSize, Integer orgId) {
		TbUserExample condition = new TbUserExample();
		Criteria criteria = condition.createCriteria();
		criteria.andUserIdNotEqualTo(0); // 超级管理员为一

		// 根据组织id得到用户列表
		if (orgId != null) {
			// 得到所有的子组织
			criteria.andOrganizationIdEqualTo(orgId);
		} else {
			// 默认查询同一个部门用户
			orgId = 1; // TODO以后修改
			// if(orgId != 1){ //如果是更用户查询全部
			criteria.andOrganizationIdEqualTo(orgId);

			return null;
			// }
		}
		int total = userDao.countByExample(condition);

		PageHelper.startPage(page, pageSize);
		List<TbUser> listUser = userDao.selectByExample(condition);

		return new PageInfo<TbUser>(total, listUser);
	}
	
	// 插入角色
	public void inserRole(int userid,String roleids){
		TbUserRole userRole = new TbUserRole();
		userRole.setUserId(userid);
		String[] split = roleids.split(",");
		for (int i = 0; i < split.length; i++) {
			if ("0".equals(split[i])) {
				continue;
			}
			userRole.setRoleId(Integer.parseInt(split[i]));
			tbuserRoleMapper.insert(userRole);
		}
	}
	// 插入权限
	public void inserRight(int userid,String rightids){
		TbUserRight userRight = new TbUserRight();
		userRight.setUserId(userid);
		String[] split = rightids.split(",");
		for (int i = 0; i < split.length; i++) {
			if ("0".equals(split[i])) {
				continue;
			}
			userRight.setRightId(Integer.parseInt(split[i]));
			tbUserRightMapper.insert(userRight);
		}
	}

	@Override
	public Integer addUser(TbUser user, String roleids, String rightids) {
		
		//根据用户的邮箱来判定重名
		
		// TODO 以后根据sessiong得到
		int currentUserId = SessionUtil.getUserid();
		
		if (user.getUserId() != null) {
			// 更新用户信息
			userDao.updateByPrimaryKeySelective(user);
			// 更新权限
			// 得到当前用于能看见的 角色
			Set<Role> currentUserRoles = getUserRoleChildList(currentUserId);
			// 删除角色
			if (currentUserRoles.size() > 0) {
				List<Integer> roleidsList = new LinkedList<>();
				for (Role role : currentUserRoles) {
					roleidsList.add(role.getRoleId());
				}
				userRoleDao.deleteUserRoles(user.getUserId(),roleidsList);
			}
			//删除 权限
			List<Right> rights = userRightDao.selectRightByUser(currentUserId);
			if (rights.size() > 0) {
				List<Integer> rightidsList = new LinkedList<>();
				for (Right right : rights) {
					rightidsList.add(right.getRightId());
				}
				userRoleDao.deleteUserRoles(user.getUserId(), rightidsList);
			}
			inserRole(user.getUserId(),roleids);
			inserRight(user.getUserId(),rightids);
			
			//判断用户是否有效，踢出用户信息删除用户权限 缓存
			cacheRedisManger.flushDB();
		} else {
			//判断用户是否存在了
			TbUserExample condition = new TbUserExample();
			Criteria emailCrieria = condition.createCriteria();
			Criteria phoneCrieria = condition.or();
			emailCrieria.andEmailEqualTo(user.getEmail());
			phoneCrieria.andPhoneEqualTo(user.getPhone());
			List<TbUser> example = userDao.selectByExample(condition);
			if(example.size() > 0 ){
				return 0;
			}
			// 添加
			user.setSalt(user.getEmail());
			user.setNickname(user.getUsername());
			Date date = new Date();
			user.setGenTime(date);
			user.setLastLoginTime(date);
			user.setLoginTime(date);
			user.setLoginCount(0);
			user.setDeleted(0);
			user.setPassword(PassWordUtil.password("SHA1", "111111", user.getEmail(), 2));
			int userid = userDao.insert(user);
			//插入角色
			inserRole(user.getUserId(),roleids);
			//插入权限
			inserRight(user.getUserId(),rightids);
		}
		return 1;
	}

	@Override
	public User selectUserById(Integer userId) {
		User user = userMaperDao.selectUserByUserId(userId);
		return user;
	}

	@Override
	public PageInfo<TbUser> listUsers(Pageable pageable, Integer orgId) {

		if (orgId == null) {
			orgId = SessionUtil.getUserOrg();
		}

		TbUserExample condition = new TbUserExample();
		Criteria criteria = condition.createCriteria();
		criteria.andOrganizationIdEqualTo(orgId);
		List<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(SessionUtil.getUserid());
		criteria.andUserIdNotIn(list); // 超级管理员为一
		criteria.andDeletedNotEqualTo(1);

		int total = userDao.countByExample(condition);

		PageHelper.startPage(pageable.getPage(), pageable.getPagesize());
		List<TbUser> listUser = userDao.selectByExample(condition);

		return new PageInfo<TbUser>(total, listUser);
	}

	@Override
	public Set<Role> listUserRoleTree(Integer userId) {
		// 得到当前用户的角色
		// 得到当前的用户(操作用户)id
		int cunrrentuserId = SessionUtil.getUserid();
		// 查询当前用户的所有角色和子角色列表
		Set<Role> currentUserRoles = getUserRoleChildList(cunrrentuserId);
		if (userId != null) {
			// 得到查询用户的角色
			List<Role> userRole = userRoleDao.selectRoleByUserId(userId);
			Iterator<Role> iterator = userRole.iterator();
			while (iterator.hasNext()) {
				Role next = iterator.next();
				if (currentUserRoles.contains(next)) {
					currentUserRoles.remove(next);
					next.setIschecked(1);
					currentUserRoles.add(next);
				}
			}
		}
		return currentUserRoles;

	}

	
	
	@Override
	public Set<Role> getUserRoleChildList(Integer userId) {
		// 查询当前用户的所有角色和子角色列表
		List<Role> userRole = userRoleDao.selectRoleByUserId(userId);
		Set<Role> userRoles = new LinkedHashSet<Role>();

		Iterator<Role> iterator = userRole.iterator();
		while (iterator.hasNext()) {
			Role next = iterator.next();
			List<Role> list = userRoleDao.selectRoleByParents(next.getRoleParents());
			userRoles.addAll(list);
		}
		userRoles.addAll(userRole);
		return userRoles;
	}

	@Override
	public List<Right> listUserRightTree(Integer userId) {
		
		int currentUserId = SessionUtil.getUserid(); //得到当前用户的id  TODO 以后重session中得到
		
		List<Right> allRight = userRightDao.selectUserRight(currentUserId);
		if(userId != null){
			//不关联到角色
			List<Right> userRightList = userRightDao.selectRightByUser(userId);
			Iterator<Right> iterator = userRightList.iterator();
			while(iterator.hasNext()){
				Right right = iterator.next();
				int indexOf = allRight.indexOf(right);
				if(indexOf != -1){
					allRight.get(indexOf).setIschecked(1);
				}
			}
		}
		return allRight;
	}

	@Override
	public int deleteUser(Integer userid) {
		//删除用户和权限
		userRoleDao.deleteUserRoles(userid, null);
		//删除用户和角色关联表
		userRightDao.deleteUserRights(userid, new LinkedList<>());
		//删除用户本身信息
		userDao.deleteByPrimaryKey(userid);
		return 0;
	}

	@Override
	public Map<String, Object> updateUserPassword(R r,String oldpassword,String newpassword) {
		int userid = SessionUtil.getUserid();
		TbUser user = userDao.selectByPrimaryKey(userid);
		
		//加密原来密码比较
		String sha1password = PassWordUtil.password("SHA1", oldpassword, user.getEmail(), 2);
		if(oldpassword != null && sha1password.equals(user.getPassword())){
			
			//加密新密码
			 String password = PassWordUtil.password("SHA1", newpassword, user.getEmail(), 2);
			 user.setPassword(password);
			 
			// 更新用户信息
			userDao.updateByPrimaryKeySelective(user);
			r.put("msg", "修改成功");
			r.put("code", 1);
			r.put("url", "/project/");
		}else{
			r.put("msg", "原密码错误");
			r.put("code", 0);
		}
		return r;
	}

}
