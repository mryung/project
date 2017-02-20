package com.project.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.project.entity.TbOrganization;
import com.project.entity.TbOrganizationExample;
import com.project.entity.TbOrganizationExample.Criteria;
import com.project.mapper.TbOrganizationMapper;
import com.project.security.shiro.SessionUtil;
import com.project.service.OrganizationService;

@Service
public class OrganizationServiceImp implements OrganizationService {

	@Autowired
	private TbOrganizationMapper orgDao;

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
			orgId = SessionUtil.getUserOrg();  //TODO 以后根据session得到用户的id(ehchance中)
		}
		
		TbOrganizationExample condition = new TbOrganizationExample();
		Criteria criteria = condition.createCriteria();
		criteria.andAvailableEqualTo((byte) 1);
		criteria.andDeletedNotEqualTo(1);
		TbOrganization organization = orgDao.selectByPrimaryKey(orgId);
		if(organization == null){
			return null;
		}
		criteria.andOrgParentsLike(organization.getOrgParents()+organization.getOrgId()+",%");
		
		List<TbOrganization> list = orgDao.selectByExample(condition);
		list.add(organization);
		return list;
		
	}
	@Override
	public TbOrganization findOrgById(Integer orgId){
		
		return orgDao.selectByPrimaryKey(orgId);
	}

}
