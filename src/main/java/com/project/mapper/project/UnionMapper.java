package com.project.mapper.project;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.project.entity.TbRight;

public interface UnionMapper {
	public List<TbRight> selectRight(Integer userid);
//	public List<TbRight> selectMenu(String userids);
	
	public List<TbRight> selectMenu(@Param("userid")Integer userid,@Param("isshow")String isshow);
}
