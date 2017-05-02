package com.project.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.project.entity.TbGroup;
import com.project.entity.TbGroupExample;

public interface TbGroupMapper {
    int countByExample(TbGroupExample example);

    int deleteByExample(TbGroupExample example);

    int deleteByPrimaryKey(Integer groupId);

    int insert(TbGroup record);

    int insertSelective(TbGroup record);

    List<TbGroup> selectByExample(TbGroupExample example);

    TbGroup selectByPrimaryKey(Integer groupId);

    int updateByExampleSelective(@Param("record") TbGroup record, @Param("example") TbGroupExample example);

    int updateByExample(@Param("record") TbGroup record, @Param("example") TbGroupExample example);

    int updateByPrimaryKeySelective(TbGroup record);

    int updateByPrimaryKey(TbGroup record);
}