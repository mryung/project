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
		
		//根据用户的id查询到用户的组织，然后根据组织显示组织列表
		int orgId = 1; //TODO 以后根据session得到用户的id(enchance中)
		
		TbOrganizationExample condition = new TbOrganizationExample();
		Criteria criteria = condition.createCriteria();
		criteria.andAvailableEqualTo((byte) 1);
		TbOrganization organization = orgDao.selectByPrimaryKey(orgId);
		criteria.andOrgParentsLike(organization.getOrgParents()+"%");
		
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

	//列出用户所拥有的的组织树
	@Override
	public List<TbOrganization> listUserOrgTree(Integer orgId) {
		
		//根据用户的id查询到用户的组织，然后根据组织显示组织列表
		if(orgId == null){
			orgId = 1;  //TODO 以后根据session得到用户的id(enchance中)
		}
		
		TbOrganizationExample condition = new TbOrganizationExample();
		Criteria criteria = condition.createCriteria();
		criteria.andAvailableEqualTo((byte) 1);
		TbOrganization organization = orgDao.selectByPrimaryKey(orgId);
		criteria.andOrgParentsLike(organization.getOrgParents()+"%");
		
		List<TbOrganization> list = orgDao.selectByExample(condition);
		return list;
		
	}
	@Override
	public TbOrganization findOrgById(Integer orgId){
		
		TbOrganizationExample condition = new TbOrganizationExample();
		Criteria criteria = condition.createCriteria();
		criteria.andAvailableEqualTo((byte)1);
		criteria.andDeletedEqualTo(1);
		List<TbOrganization> list = orgDao.selectByExample(condition);
		
		if(list.size() >= 1){
			return list.get(0);
		}else{
			return null;
		}
//		return orgDao.selectByPrimaryKey(orgId);
	}

}
