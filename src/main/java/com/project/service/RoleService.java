package com.project.service;

import java.util.List;
import java.util.Set;

import com.project.entity.TbRole;
import com.project.entity.project.Role;

public interface RoleService {
	public List<TbRole> findRoleList();
	
	//列出用户的角色树
	public Set<Role> listUserRoleTree(Integer userId);
	
	
}
