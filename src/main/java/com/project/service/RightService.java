package com.project.service;

import java.util.List;

import com.project.entity.TbRight;

public interface RightService {
	
	//显示列表树
	List<TbRight> listRightTree();
	
	TbRight findRightById(Integer rightid);
	
	List<TbRight> findRights(String parentid);
	
	List<TbRight> findRights(int page,int pageSize,String parentid);
}
