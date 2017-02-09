package com.project.mapper.project;

import java.util.List;

import com.project.entity.project.Role;

public interface UserRoleMapper {
 List<Role> selectRoleByUserId(int userId);
 //通过父前缀得到用户
 List<Role> selectRoleByParents(String parents);
}
