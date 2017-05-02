package com.project.mapper;

import java.util.List;
import java.util.Map;

import com.project.entity.ScheduleJobEntity;

public interface ScheduleJobDao {

	ScheduleJobEntity queryObject(Long jobId);

	List<ScheduleJobEntity> queryList(Map<String, Object> map);

	int queryTotal(Map<String, Object> map);

	void save(ScheduleJobEntity scheduleJob);

	void update(ScheduleJobEntity scheduleJob);

	void deleteBatch(Long[] jobIds);

	int updateBatch(Map<String, Object> map);

}
