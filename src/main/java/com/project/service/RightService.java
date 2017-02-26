package com.project.service;

import java.util.List;

import com.myproject.message.Pageable;
import com.project.entity.TbRight;
import com.project.entity.project.Right;
import com.project.entity.project.User;

public interface RightService {
	
	//显示列表树
	List<TbRight> listRightTree();
	
	TbRight findRightById(Integer rightid);
	
	List<TbRight> findRightsByParentid(Pageable pageable,int parentid);
	
	List<TbRight> findRightsByParentid(int page,int pageSize,String parentid);
	
	public List<Right> listUserRightTree(Integer userId);

	int saveRight(TbRight right);

	List<User> selectUserListByRightid(Pageable pageable, Integer rightid);

	List<TbRight> selectRoleListByRightid(Pageable pageable, Integer rightid);
}
