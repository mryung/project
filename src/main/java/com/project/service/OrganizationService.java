package com.project.service;

import java.util.List;

import com.project.entity.TbOrganization;

public interface OrganizationService {
	
	List<TbOrganization> listTree();

	List<TbOrganization> listOrgByPage(int page, int pagesize);
}
