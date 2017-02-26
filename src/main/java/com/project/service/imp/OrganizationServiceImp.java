package com.project.service.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.myproject.message.PageInfo;
import com.myproject.message.Pageable;
import com.project.entity.TbOrganization;
import com.project.entity.TbOrganizationExample;
import com.project.entity.TbUser;
import com.project.entity.TbOrganizationExample.Criteria;
import com.project.mapper.TbOrganizationMapper;
import com.project.mapper.project.UserOrgMapper;
import com.project.security.shiro.SessionUtil;
import com.project.service.OrganizationService;

@Service
public class OrganizationServiceImp implements OrganizationService {

	@Autowired
	private TbOrganizationMapper orgDao;
	
	@Autowired
	private UserOrgMapper userOrgMapper;
	
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

	@Override
	public PageInfo<TbUser> findOrgUsers(Pageable pageable, Integer orgid) {
		
		PageInfo<TbUser> pageInfo = new PageInfo<TbUser>();
		
		//得到当前组织所有的用户数
		int total = userOrgMapper.countOrgUser(orgid);
		pageInfo.setTotal(total);
		
		PageHelper.startPage(pageable.getPage(), pageable.getPagesize());
		pageInfo.setRows(userOrgMapper.selectOrgUser(orgid));
		return pageInfo;
	}

	@Override
	public int saveOrg(TbOrganization org) {
		//得到父亲的列表
		if(org.getOrgParentId() == null || org.getOrgParentId() == 0){
			org.setOrgParentId(0);
			org.setOrgParents("0,");
		}else{
			TbOrganization organization = orgDao.selectByPrimaryKey(org.getOrgParentId());
			org.setOrgParents(organization.getOrgParents()+organization.getOrgId()+",");
		}
		if(org.getOrgId() == null){
			//添加
			org.setOrgGenTime(new Date());
			orgDao.insertSelective(org);
		}else{
			//更新
			orgDao.updateByPrimaryKeySelective(org);
		}
		return org.getOrgId();
	}

	@Override
	public int deleteOrg(Integer orgid) {
		TbOrganization organization = orgDao.selectByPrimaryKey(orgid);
		organization.setDeleted(1);
		orgDao.updateByPrimaryKeySelective(organization);
		return 0;
	}

}
