package com.project.service;

import java.util.List;

import com.project.entity.TbRight;

public interface MenuService {
	public List<TbRight> findMenu(Integer userid);
}
