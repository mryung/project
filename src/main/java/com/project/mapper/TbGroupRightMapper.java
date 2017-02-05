package com.project.mapper;

import com.project.entity.TbGroupRight;
import com.project.entity.TbGroupRightExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbGroupRightMapper {
    int countByExample(TbGroupRightExample example);

    int deleteByExample(TbGroupRightExample example);

    int deleteByPrimaryKey(Integer groupRightId);

    int insert(TbGroupRight record);

    int insertSelective(TbGroupRight record);

    List<TbGroupRight> selectByExample(TbGroupRightExample example);

    TbGroupRight selectByPrimaryKey(Integer groupRightId);

    int updateByExampleSelective(@Param("record") TbGroupRight record, @Param("example") TbGroupRightExample example);

    int updateByExample(@Param("record") TbGroupRight record, @Param("example") TbGroupRightExample example);

    int updateByPrimaryKeySelective(TbGroupRight record);

    int updateByPrimaryKey(TbGroupRight record);
}