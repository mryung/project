package com.project.service.imp;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.TbRole;
import com.project.entity.project.Role;
import com.project.mapper.TbRoleMapper;
import com.project.mapper.TbUserMapper;
import com.project.mapper.project.UserRoleMapper;
import com.project.service.RoleService;

@Service
public class RoleServiceImp implements RoleService {

	@Autowired
	private TbRoleMapper roleDao;
	
	@Autowired 
	private TbUserMapper userDao;
	
	@Autowired
	private UserRoleMapper userRoleDao;
	
	@Override
	public List<TbRole> findRoleList() {
		
		return roleDao.selectByExample(null);
	}
	
	//用在给用户分配权限时
	@Override
	public List<Role> listUserRoleTree(Integer userId) {
		//得到当前的用户(操作用户)id
		int cunrrentuserId = 1; //TODO 以后重enchance中得到
		//得到当前用的的所有角色
		List<Role> currentUserRole = userRoleDao.selectRoleByUserId(cunrrentuserId);
		//查询当前用户的所有角色和子角色列表
		List<Role> currentUserRoles =  new LinkedList<Role>();
		Iterator<Role> iterator = currentUserRole.iterator();
		while (iterator.hasNext()) {
			Role next = iterator.next();
			List<Role> userRole = userRoleDao.selectRoleByParents(next.getRoleParents());
			currentUserRoles.addAll(userRole);
		}
		if(userId != null){
			//得到查询用户的角色
			List<Role> userRole = userRoleDao.selectRoleByUserId(userId);
			iterator = userRole.iterator();
			while (iterator.hasNext()) {
				Role next = iterator.next();
				if(currentUserRoles.contains(next)){
					currentUserRoles.remove(next);
					next.setIschecked(1);
					currentUserRoles.add(next);
				}
			}
		}
		return currentUserRoles;
	}

}
