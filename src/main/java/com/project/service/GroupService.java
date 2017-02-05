package com.project.service;

import java.util.List;

import com.project.entity.TbGroup;

public interface GroupService {
	 public List<TbGroup> listGroup();
	 public List<TbGroup> listGroupByPage(int page,int pageSize);
}
