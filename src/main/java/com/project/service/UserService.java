package com.project.service;

import com.myproject.message.PageInfo;
import com.project.entity.TbUser;

public interface UserService {
	
	public PageInfo<TbUser> listUser(int page,int pageSize,Integer orgId);

	public boolean addUser(TbUser user);	
	
}
