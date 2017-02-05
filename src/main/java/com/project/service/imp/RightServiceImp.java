package com.project.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.project.entity.TbRight;
import com.project.entity.TbRightExample;
import com.project.entity.TbRightExample.Criteria;
import com.project.mapper.TbRightMapper;
import com.project.service.RightService;

@Service
public class RightServiceImp implements RightService {
	
	@Autowired
	private TbRightMapper rightDao;
	
	@Override
	public List<TbRight> listRightTree() {
		/**
		 * 以后根据用户权限来显示 列表
		 */
		List<TbRight> rightList = rightDao.selectByExample(null);
		return rightList;
	}

	@Override
	public TbRight findRightById(Integer rightid) {
		/**
		 * 根据id 得到权限信息数据
		 */
		TbRight right = rightDao.selectByPrimaryKey(rightid);
		return right;
	}

	@Override
	public List<TbRight> findRights(String parentid) {
		
		TbRightExample condition  = new TbRightExample();
		Criteria criteria = condition.createCriteria();
		criteria.andRightParentsLike("%,"+parentid+",%");
		
		return rightDao.selectByExample(condition);
	}

	@Override
	public List<TbRight> findRights(int page, int pageSize, String parentid) {
		PageHelper.startPage(page, pageSize);
		TbRightExample condition  = new TbRightExample();
		Criteria criteria = condition.createCriteria();
		criteria.andRightParentsLike("%,"+parentid+",%");
		
		
		return rightDao.selectByExample(condition);
	}

}
