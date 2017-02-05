package com.project.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.project.entity.TbGroup;
import com.project.entity.TbGroupExample;
import com.project.entity.TbOrganization;
import com.project.entity.TbOrganizationExample;
import com.project.entity.TbOrganizationExample.Criteria;
import com.project.mapper.TbOrganizationMapper;
import com.project.service.OrganizationService;

@Service
public class OrganizationServiceImp implements OrganizationService {

	@Autowired
	private TbOrganizationMapper orgDao;
	
	@Override
	public List<TbOrganization> listTree() {
		
		TbOrganizationExample condition = new TbOrganizationExample();
		Criteria criteria = condition.createCriteria();
		criteria.andAvailableEqualTo((byte) 1);
		
		List<TbOrganization> list = orgDao.selectByExample(condition);
		return list;
	}

	@Override
	public List<TbOrganization> listOrgByPage(int page, int pagesize) {
		PageHelper.startPage(page, pagesize);
		
		TbOrganizationExample condition = new TbOrganizationExample();
	    Criteria criteria = condition.createCriteria();
	    criteria.andAvailableNotEqualTo((byte) 0);
		
		return orgDao.selectByExample(condition);
	}

}
