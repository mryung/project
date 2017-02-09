package com.project.mapper.project;

import java.util.List;

import com.project.entity.project.Right;

public interface UserRightMapper {
	public List<Right> selectUserRight(Integer userid);
	public List<Right> selectAllRight(String userids);
	public List<Right> selectRightByUser(Integer userId);
}
