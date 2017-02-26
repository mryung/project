package com.project.service.imp;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myproject.message.Pageable;
import com.myproject.message.R;
import com.project.entity.TbRight;
import com.project.entity.TbRightExample;
import com.project.entity.TbUserRight;
import com.project.entity.TbRightExample.Criteria;
import com.project.entity.project.Right;
import com.project.entity.project.Role;
import com.project.entity.project.User;
import com.project.mapper.TbRightMapper;
import com.project.mapper.TbUserRightMapper;
import com.project.mapper.project.RightMapper;
import com.project.mapper.project.UnionMapper;
import com.project.mapper.project.UserMapper;
import com.project.mapper.project.UserRightMapper;
import com.project.security.shiro.SessionUtil;
import com.project.service.RightService;
import com.project.service.UserService;

@Service
public class RightServiceImp implements RightService {
	
	@Autowired
	private TbRightMapper rightMapper;
	
	@Autowired
	private UserRightMapper userRightDao;
	
	@Autowired
	private TbUserRightMapper tbUserRightDao;
	
	@Autowired
	private UnionMapper menuDao;
	
	@Autowired
	private UserMapper userDao;
	
	@Autowired
	private RightMapper rightDao;
	
	@Autowired
	private UserService userservice;
	
	@Override
	public List<TbRight> listRightTree() {
		/**
		 * 以后根据用户权限来显示 列表
		 */
		int userid = SessionUtil.getUserid();
		List<TbRight> rightList = menuDao.selectMenu(userid,"0,1");
		return rightList;
	}

	@Override
	public TbRight findRightById(Integer rightid) {
		/**
		 * 根据id 得到权限信息数据
		 */
		TbRight right = rightMapper.selectByPrimaryKey(rightid);
		return right;
	}

	@Override
	public List<TbRight> findRightsByParentid(Pageable pageable,int parentid) {
		
		TbRightExample condition  = new TbRightExample();
		Criteria criteria = condition.createCriteria();
		criteria.andRightParentsLike("%,"+parentid+",%");
		
		TbRight parent = rightMapper.selectByPrimaryKey(parentid);
		List<TbRight> list = null;
		if(pageable.getPage() == 1){
			PageHelper.startPage(pageable.getPage(), pageable.getPagesize()-1);
			list = rightMapper.selectByExample(condition);
			list.add(0, parent);
		}else{
			PageHelper.startPage(pageable.getPage(), pageable.getPagesize());
			list = rightMapper.selectByExample(condition);
		}
		
		return list;
	}

	@Override
	public List<TbRight> findRightsByParentid(int page, int pageSize, String parentid) {
		PageHelper.startPage(page, pageSize);
		TbRightExample condition  = new TbRightExample();
		Criteria criteria = condition.createCriteria();
		criteria.andRightParentsLike("%,"+parentid+",%");
		
		
		return rightMapper.selectByExample(condition);
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
			}
		}
		return allRight;
	}

	@Override
	public int saveRight(TbRight right) {
		
		//更新 权限父目录结构
		//得到父目录结构
		TbRight parentRight = rightMapper.selectByPrimaryKey(right.getRightParentId());
		
		right.setRightParents(parentRight.getRightParents()+parentRight.getRightId()+",");
		if(right.getRightId() != null){
			//更新
		
			rightMapper.updateByPrimaryKeySelective(right);
		}else{
			//保存
			rightMapper.insertSelective(right);
		}
		
		//给管理员添加对应的权限
		TbUserRight userRight = new TbUserRight();
		userRight.setRightId(right.getRightId());
		userRight.setUserId(1);
		tbUserRightDao.insertSelective(userRight);
		
		return right.getRightId();
	}
	
	@Override
	public List<User> selectUserListByRightid(Pageable pageable,Integer rightid){
		PageHelper.startPage(pageable.getPage(), pageable.getPagesize());
		int orgid = SessionUtil.getUserOrg();
		List<User> list = userDao.selectUserByRightid(rightid,"%,"+orgid+",%");
		
		return list;
	}

	@Override
	public List<TbRight> selectRoleListByRightid(Pageable pageable, Integer rightid) {
		PageHelper.startPage(pageable.getPage(), pageable.getPagesize());
		//得到当前用户的角色列表
		int userid = SessionUtil.getUserid();
		Set<Role> roleList = userservice.getUserRoleChildList(userid);
		
		Iterator<Role> iterator = roleList.iterator();
		List<Integer> roleIdList = new LinkedList<>();
		roleIdList.add(0);
		while (iterator.hasNext()){
			Role role = iterator.next();
			roleIdList.add(role.getRoleId());
		}
		List<TbRight> list = rightDao.selectRoleListByRightid( rightid,roleIdList);
		return list;
	}

}
