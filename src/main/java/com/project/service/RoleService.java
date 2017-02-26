package com.project.service;

import java.util.List;
import java.util.Set;

import com.myproject.message.PageInfo;
import com.myproject.message.Pageable;
import com.project.entity.TbRole;
import com.project.entity.project.Right;
import com.project.entity.project.Role;
import com.project.entity.project.User;

public interface RoleService {
	public List<TbRole> findRoleList();
	
	public PageInfo<TbRole> findRoleListByPage(Pageable pageable, Integer roleId);

	public int  deleteRolde(Integer roleId);

	public int  saveRole(TbRole role, String rights);

	public TbRole findRoleById(Integer roleId);

	public List<Right> findRightTree(Integer roleId);

	public PageInfo<User> findUserByRoleid(Pageable pageable, Integer roleId);
	
	
}
