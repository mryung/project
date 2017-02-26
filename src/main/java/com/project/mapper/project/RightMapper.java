package com.project.mapper.project;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.project.entity.TbRight;

public interface RightMapper {
	List<TbRight> selectRoleListByRightid(@Param("rightid")Integer rightid
			,@Param("roleIdList") List<Integer> roleIdList);
}
