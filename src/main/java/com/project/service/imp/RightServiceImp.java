package com.project.service.imp;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.project.entity.TbRight;
import com.project.entity.TbRightExample;
import com.project.entity.TbRightExample.Criteria;
import com.project.entity.project.Right;
import com.project.mapper.TbRightMapper;
import com.project.mapper.project.UnionMapper;
import com.project.mapper.project.UserRightMapper;
import com.project.service.RightService;

@Service
public class RightServiceImp implements RightService {
	
	@Autowired
	private TbRightMapper rightDao;
	
	@Autowired
	private UserRightMapper userRightDao;
	
	@Autowired
	private UnionMapper menuDao;
	
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

	@Override
	public List<Right> listUserRightTree(Integer userId) {
		int currentUserId = 1; //得到当前用户的id  TODO 以后重session中得到
		
		List<Right> allRight = userRightDao.selectUserRight(currentUserId);

		if(userId != null){
			//不关联到角色
			List<Right> userRightList = userRightDao.selectRightByUser(userId);
			Iterator<Right> iterator = userRightList.iterator();
			while(iterator.hasNext()){
				Right right = iterator.next();
				int indexOf = allRight.indexOf(right);
				if(indexOf != -1){
					allRight.get(indexOf).setIschecked(1);
				}
//				if(allRight.contains(right)){
//					allRight.remove(right);
//					right.setIschecked(1);
//					allRight.add(right);
//				}
			}
		}
		return allRight;
	}

}
