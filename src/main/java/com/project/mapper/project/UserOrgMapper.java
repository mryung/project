package com.project.mapper.project;

import java.util.List;

import com.project.entity.TbUser;

public interface UserOrgMapper {
	
	int countOrgUser(Integer orgid);
	
	List<TbUser> selectOrgUser(Integer orgid);
	
}
