package com.project.mapper.project;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.project.entity.project.Right;
import com.project.entity.project.Role;

public interface RoleRightMapper {
	
	public List<Right> selectRoleRight(@Param("roleId") Integer roleId);
	
	public void deleteRoleRights(@Param("roleId") Integer roleId,@Param("rightids")List<Integer> rightids);
}
