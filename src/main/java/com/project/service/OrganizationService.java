package com.project.service;

import java.util.List;

import com.project.entity.TbOrganization;

public interface OrganizationService {
	
	List<TbOrganization> listTree();

	List<TbOrganization> listOrgByPage(int page, int pagesize);
	
	//列出用户所拥有的的组织树
	List<TbOrganization> listUserOrgTree(Integer orgId);

	TbOrganization findOrgById(Integer orgId);
}
