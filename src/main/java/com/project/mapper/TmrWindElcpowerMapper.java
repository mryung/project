package com.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.project.entity.project.TmrWindElcpower201702;
import com.project.entity.project.TmrWindElcpower201702Example;

public interface TmrWindElcpowerMapper {
	
//	int selectBuildPower(@Param("tableName") String tableName,
//			@Param("startTime") long startTime,@Param("endTime") long endTime,@Param("point") List<Integer> point);
	
	Double selectBuildPower();
	
    int insertSelective(TmrWindElcpower201702 record);

    List<TmrWindElcpower201702> selectByExample(TmrWindElcpower201702Example example);

    int updateByExampleSelective(@Param("record") TmrWindElcpower201702 record, @Param("example") TmrWindElcpower201702Example example);

    int updateByExample(@Param("record") TmrWindElcpower201702 record, @Param("example") TmrWindElcpower201702Example example);
}