package com.project.service.imp;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.TbRight;
import com.project.mapper.project.UnionMapper;
import com.project.service.MenuService;

@Service
public class MenuServerciImp implements MenuService {
	
	@Autowired
	private UnionMapper unionMapper;
	
	@Override
	public List<TbRight> findMenu(Integer userid) {
		
		List<TbRight> menu = unionMapper.selectMenu(userid,"1");
		
		return menu;
		
//		//查到用户权限的列表目录
//		List<TbRight> rights = unionMapper.selectRight(userid);
//		Iterator<TbRight> iterator = rights.iterator();
//		
//		StringBuilder userids = new StringBuilder("0"); 
//		while (iterator.hasNext()) {
//			TbRight right = iterator.next();
//			userids.append(","+right.getRightParents()+right.getRightId());
//		}
////		userids.append("0");
//		System.out.println(userids.toString());
//		//查到用户的权限列表
//		return unionMapper.selectMenu(userids.toString());
	}

}
