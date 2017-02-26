package com.project.mapper.project;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.project.entity.project.User;

public interface UserMapper {
	User selectUserByUserId(Integer userId);
	public List<User> selectUserByRightid(@Param("rightid") Integer rightid,@Param("parents")String parents);
}
