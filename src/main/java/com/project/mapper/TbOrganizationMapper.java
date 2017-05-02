package com.project.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.project.entity.TbOrganization;
import com.project.entity.TbOrganizationExample;

public interface TbOrganizationMapper {
    int countByExample(TbOrganizationExample example);

    int deleteByExample(TbOrganizationExample example);

    int deleteByPrimaryKey(Integer orgId);

    int insert(TbOrganization record);

    int insertSelective(TbOrganization record);

    List<TbOrganization> selectByExample(TbOrganizationExample example);

    TbOrganization selectByPrimaryKey(Integer orgId);

    int updateByExampleSelective(@Param("record") TbOrganization record, @Param("example") TbOrganizationExample example);

    int updateByExample(@Param("record") TbOrganization record, @Param("example") TbOrganizationExample example);

    int updateByPrimaryKeySelective(TbOrganization record);

    int updateByPrimaryKey(TbOrganization record);
}