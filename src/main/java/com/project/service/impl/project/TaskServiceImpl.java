package com.project.service.impl.project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.message.PageInfo;
import com.myproject.message.Pageable;
import com.project.entity.ScheduleJobEntity;
import com.project.mapper.ScheduleJobDao;
import com.project.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private ScheduleJobDao sckeduleJobDao;
	
	@Override
	public PageInfo<ScheduleJobEntity> TaskPageList(Pageable pageable){
		Map<String, Object> map = new HashMap<>();
		int total = sckeduleJobDao.queryTotal(map);
		List<ScheduleJobEntity> list = sckeduleJobDao.queryList(map);
		PageInfo<ScheduleJobEntity> pageinfo = new PageInfo<ScheduleJobEntity>(total, list);
		return pageinfo;
	}
	
	

}
