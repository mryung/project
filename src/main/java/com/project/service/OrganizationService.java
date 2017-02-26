package com.project.service;

import java.util.List;

import com.myproject.message.PageInfo;
import com.myproject.message.Pageable;
import com.project.entity.TbOrganization;
import com.project.entity.TbUser;

public interface OrganizationService {

	List<TbOrganization> listOrgByPage(int page, int pagesize);
	
	//列出用户所拥有的的组织树
	List<TbOrganization> listUserOrgTree(Integer orgId);

	TbOrganization findOrgById(Integer orgId);

	PageInfo<TbUser> findOrgUsers(Pageable pageable, Integer orgid);

	int  saveOrg(TbOrganization org);

	int deleteOrg(Integer orgid);
}
