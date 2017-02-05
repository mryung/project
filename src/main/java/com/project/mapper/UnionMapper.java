package com.project.mapper;

import java.util.List;

import com.project.entity.TbRight;

public interface UnionMapper {
	public List<TbRight> selectRight(Integer userid);
	public List<TbRight> selectMenu(String userids);
}
