package com.project.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.project.entity.TbUserGroup;
import com.project.entity.TbUserGroupExample;

public interface TbUserGroupMapper {
    int countByExample(TbUserGroupExample example);

    int deleteByExample(TbUserGroupExample example);

    int deleteByPrimaryKey(Integer userGroupId);

    int insert(TbUserGroup record);

    int insertSelective(TbUserGroup record);

    List<TbUserGroup> selectByExample(TbUserGroupExample example);

    TbUserGroup selectByPrimaryKey(Integer userGroupId);

    int updateByExampleSelective(@Param("record") TbUserGroup record, @Param("example") TbUserGroupExample example);

    int updateByExample(@Param("record") TbUserGroup record, @Param("example") TbUserGroupExample example);

    int updateByPrimaryKeySelective(TbUserGroup record);

    int updateByPrimaryKey(TbUserGroup record);
}