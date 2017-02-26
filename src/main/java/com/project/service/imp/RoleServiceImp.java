package com.project.service.imp;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.myproject.message.PageInfo;
import com.myproject.message.Pageable;
import com.project.entity.TbRole;
import com.project.entity.TbRoleExample;
import com.project.entity.TbRoleExample.Criteria;
import com.project.entity.TbRoleRight;
import com.project.entity.project.Right;
import com.project.entity.project.Role;
import com.project.entity.project.User;
import com.project.mapper.TbRoleMapper;
import com.project.mapper.TbRoleRightMapper;
import com.project.mapper.project.RoleRightMapper;
import com.project.mapper.project.UserRightMapper;
import com.project.mapper.project.UserRoleMapper;
import com.project.security.shiro.SessionUtil;
import com.project.service.RoleService;

@Service
public class RoleServiceImp implements RoleService {

	@Autowired
	private TbRoleMapper roleDao;
	
	@Autowired
	private UserRoleMapper userRoleDao;
	
	@Autowired
	private UserRightMapper userRightDao;
	
	@Autowired
	private RoleRightMapper roleRightDao;
	
	@Autowired
	private TbRoleRightMapper	tbRoleRightMapper;
	
	@Override
	public List<TbRole> findRoleList() {
		
		return roleDao.selectByExample(null);
	}

	@Override
	public PageInfo<TbRole> findRoleListByPage(Pageable pageable, Integer roleId) {
		TbRoleExample condition = new TbRoleExample();
		Criteria criteria = condition.createCriteria();
		criteria.andAvailableEqualTo(1);
		criteria.andRoleIdEqualTo(roleId);
		criteria.andDeletedEqualTo(0);
		PageInfo<TbRole> pageInfo = new PageInfo<TbRole>();
		int total = roleDao.countByExample(condition);
		if(total == 0){
			return pageInfo;
		}
		pageInfo.setTotal(total);
		PageHelper.startPage(pageable.getPage(), pageable.getPagesize());
		pageInfo.setRows(roleDao.selectByExample(condition));
		return pageInfo;
	}

	@Override
	public int deleteRolde(Integer roleId) {
		TbRole role = roleDao.selectByPrimaryKey(roleId);
		role.setDeleted(1);
		roleDao.updateByPrimaryKey(role);
		return 0;
	}

	@Override
	public int saveRole(TbRole role, String rights) {
		
		//根目录不让添加
		if(role.getRoleParentId() == 0){
			return -1;
		}
		
		//设置父角色
		TbRole parentRole = roleDao.selectByPrimaryKey(role.getRoleParentId());
		role.setRoleParents(parentRole.getRoleParents()+parentRole.getRoleId()+",");
		
		
		if(role.getRoleId() == null){
			//添加
			role.setRoleGenTime(new Date());
			roleDao.insertSelective(role);
		}else{
			//更新
			//删除当前用户能看见角色的搜有权限
			int currentUserId = SessionUtil.getUserid();
			List<Right> allRight = userRightDao.selectUserRight(currentUserId);
		
			List<Integer> rightList = new LinkedList<>();
			rightList.add(0);
			for (Right right : allRight) {
					rightList.add(right.getRightId());
			}
			roleRightDao.deleteRoleRights(role.getRoleId(),rightList);
		}
		
		//插入角色权限
		String[] strings = rights.split(",");
		for (int i = 0; i < strings.length; i++) {
			int rightId = Integer.parseInt(strings[i]);
			if(rightId == 0 ){
				continue;
			}
			TbRoleRight roleRight = new TbRoleRight();
			roleRight.setRightId(rightId);
			roleRight.setRoleId(role.getRoleId());
			tbRoleRightMapper.insert(roleRight);
		}
		
		return role.getRoleId();
	}

	@Override
	public TbRole findRoleById(Integer roleId) {
		TbRole role = roleDao.selectByPrimaryKey(roleId);
		return role;
	}

	@Override
	public List<Right> findRightTree(Integer roleId) {
		//得到当前用户的id
		int currentUserId = SessionUtil.getUserid();
		List<Right> allRight = userRightDao.selectUserRight(currentUserId);
		
		if(roleId != null){
			//得到角色拥有的权限
			List<Right> rights = roleRightDao.selectRoleRight(roleId);
			Iterator<Right> iterator = rights.iterator();
			while(iterator.hasNext()){
				Right right = iterator.next();
				int index = allRight.indexOf(right);
				if(index != -1){
					allRight.get(index).setIschecked(1);
				}
			}
		}
		return allRight;
	}

	@Override
	public PageInfo<User> findUserByRoleid(Pageable pageable, Integer roleId) {
		int total = userRoleDao.countUserByRoleId(roleId);
		PageInfo<User> pageInfo = new PageInfo<>();
		pageInfo.setTotal(total);
		if(total == 0){
			return pageInfo;
		}
		PageHelper.startPage(pageable.getPage(), pageable.getPagesize());
		List<User> user = userRoleDao.selectUserByRoleId(roleId);
		pageInfo.setRows(user);
		return null;
	}

}
