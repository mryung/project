package com.project.mapper;

import com.project.entity.TbUserRight;
import com.project.entity.TbUserRightExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserRightMapper {
    int countByExample(TbUserRightExample example);

    int deleteByExample(TbUserRightExample example);

    int deleteByPrimaryKey(Integer userRightId);

    int insert(TbUserRight record);

    int insertSelective(TbUserRight record);

    List<TbUserRight> selectByExample(TbUserRightExample example);

    TbUserRight selectByPrimaryKey(Integer userRightId);

    int updateByExampleSelective(@Param("record") TbUserRight record, @Param("example") TbUserRightExample example);

    int updateByExample(@Param("record") TbUserRight record, @Param("example") TbUserRightExample example);

    int updateByPrimaryKeySelective(TbUserRight record);

    int updateByPrimaryKey(TbUserRight record);
}