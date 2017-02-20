package com.project.service;

import java.util.List;
import java.util.Set;

import com.myproject.message.PageInfo;
import com.myproject.message.Pageable;
import com.project.entity.TbUser;
import com.project.entity.project.Right;
import com.project.entity.project.Role;
import com.project.entity.project.User;

public interface UserService {
	
	@Deprecated
	public PageInfo<TbUser> listUser(int page,int pageSize,Integer orgId);

	public Integer addUser(TbUser user,String roleids,String orgIds);
	public User selectUserById(Integer userId);
	
	public PageInfo<TbUser> listUsers(Pageable pageable,Integer orgId);

	public Set<Role> listUserRoleTree(Integer userId);
	
	public Set<Role>  getUserRoleChildList(Integer userId);

	public List<Right> listUserRightTree(Integer userId);
	
}
