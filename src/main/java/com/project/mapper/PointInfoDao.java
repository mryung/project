package com.project.mapper;

import java.util.List;

import com.project.entity.PointInfo;

public interface PointInfoDao {
	PointInfo queryObject(Long pointId);

	List<PointInfo> queryList();

	int queryTotal();

	void save(PointInfo pointInfo);

	void update(PointInfo pointInfo);
	
	PointInfo queryPoint(Integer pointCode);

}
