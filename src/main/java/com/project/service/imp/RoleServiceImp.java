package com.project.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.TbRole;
import com.project.mapper.TbRoleMapper;
import com.project.service.RoleService;

@Service
public class RoleServiceImp implements RoleService {

	@Autowired
	private TbRoleMapper roleDao;
	@Override
	public List<TbRole> findRoleList() {
		
		return roleDao.selectByExample(null);
	}

}
