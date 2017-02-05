package com.project.mapper;

import com.project.entity.TbGroupRole;
import com.project.entity.TbGroupRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbGroupRoleMapper {
    int countByExample(TbGroupRoleExample example);

    int deleteByExample(TbGroupRoleExample example);

    int deleteByPrimaryKey(Integer groupRoleId);

    int insert(TbGroupRole record);

    int insertSelective(TbGroupRole record);

    List<TbGroupRole> selectByExample(TbGroupRoleExample example);

    TbGroupRole selectByPrimaryKey(Integer groupRoleId);

    int updateByExampleSelective(@Param("record") TbGroupRole record, @Param("example") TbGroupRoleExample example);

    int updateByExample(@Param("record") TbGroupRole record, @Param("example") TbGroupRoleExample example);

    int updateByPrimaryKeySelective(TbGroupRole record);

    int updateByPrimaryKey(TbGroupRole record);
}