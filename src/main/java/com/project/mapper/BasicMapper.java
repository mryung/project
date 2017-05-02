package com.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BasicMapper {
	Double basicSelect(@Param("tableName") String tableName,
			@Param("startTime")Long startTime,@Param("endTime")Long endTime,
			@Param("pointList")List<Integer> pointList );
	Double basicSelectByPoint(@Param("tableName") String tableName,
			@Param("startTime")Long startTime,@Param("endTime")Long endTime,
			@Param("pointList")String pointList );
	
	Double basicSelect1(@Param("tableName1") String tableName1,
			@Param("tableName2") String tableName2,
			@Param("startTime")Long startTime,@Param("endTime")Long endTime,
			@Param("pointList")List<Integer> pointList );
	Double basicSelectByPoint1(@Param("tableName1") String tableName1,
			@Param("tableName2") String tableName2,
			@Param("startTime")Long startTime,@Param("endTime")Long endTime,
			@Param("pointList")String pointList );
}
