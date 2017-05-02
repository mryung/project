package com.project.service.impl.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.project.entity.TbGroup;
import com.project.entity.TbGroupExample;
import com.project.entity.TbGroupExample.Criteria;
import com.project.mapper.TbGroupMapper;
import com.project.service.GroupService;

@Service
public class GroupServiceImp implements GroupService {

	@Autowired
	private TbGroupMapper groupDao;
	
	@Override
	public List<TbGroup> listGroup() {
		
		TbGroupExample condition = new TbGroupExample();
	    Criteria criteria = condition.createCriteria();
	    criteria.andAvailableNotEqualTo(0);
		
		return groupDao.selectByExample(condition);
	}

	@Override
	public List<TbGroup> listGroupByPage(int page, int pageSize) {
		
		PageHelper.startPage(page, pageSize);
		
		TbGroupExample condition = new TbGroupExample();
	    Criteria criteria = condition.createCriteria();
	    criteria.andAvailableNotEqualTo(0);
		
		return groupDao.selectByExample(condition);
	}
	
}
