package com.project.mapper.project;

import com.project.entity.project.User;

public interface UserMapper {
	User selectUserByUserId(Integer userId);
}
