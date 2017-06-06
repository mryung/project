package com.project.mapper.project;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.project.entity.project.Right;

public interface UserRightMapper {
	public List<Right> selectUserRight(Integer userid);
	public List<Right> selectAllRight(String userids);
	public List<Right> selectRightByUser(Integer userId);
	void deleteUserRights(@Param("userid")Integer userid,@Param("rightids") List<Integer> rightids);
}
