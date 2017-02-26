package com.project.mapper.project;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.project.entity.project.Role;
import com.project.entity.project.User;

public interface UserRoleMapper {
 List<Role> selectRoleByUserId(int userId);
 //通过父前缀得到用户
 List<Role> selectRoleByParents(String parents);
 void deleteUserRoles(@Param("userid")Integer userid,@Param("roleids") List<Integer> roleids);
 
 int countUserByRoleId(@Param("roleId")Integer roleId);
 List<User> selectUserByRoleId(@Param("roleId") Integer roleId);
}
