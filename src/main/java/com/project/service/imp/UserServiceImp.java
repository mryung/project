package com.project.service.imp;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.myproject.message.PageInfo;
import com.project.entity.TbUser;
import com.project.entity.TbUserExample;
import com.project.entity.TbUserExample.Criteria;
import com.project.mapper.TbUserMapper;
import com.project.service.UserService;


@Service
public class UserServiceImp implements UserService {
	@Autowired
	private TbUserMapper userDao;
	
	@Override
	public PageInfo<TbUser> listUser(int page,int pageSize,Integer orgId){
		TbUserExample condition = new TbUserExample();
		Criteria criteria = condition.createCriteria();
		criteria.andUserIdNotEqualTo(0); //超级管理员为一
		
		//根据组织id得到用户列表
		if(orgId != null){
			criteria.andOrganizationIdEqualTo(orgId);
		}
		int total = userDao.countByExample(condition);
		
		PageHelper.startPage(page, pageSize);
		List<TbUser> listUser = userDao.selectByExample(condition);
		
		return new PageInfo<TbUser>(total, listUser);
	}

	@Override
	public boolean addUser(TbUser user) {
		//做业务逻辑
		//设置密码的盐
		user.setSalt(UUID.randomUUID().toString());
		user.setNickname(user.getUsername());
		Date date = new Date();
		user.setGenTime(date);
		user.setLastLoginTime(date);
		user.setLoginTime(date);
		user.setLoginCount(0);
		user.setPassword("111111");
		int userid = userDao.insert(user);
		System.out.println(userid+"************************");
		return true;
	}
}
