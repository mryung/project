package com.project.service;

import com.myproject.message.PageInfo;
import com.myproject.message.Pageable;
import com.project.entity.ScheduleJobEntity;

public interface TaskService {

	PageInfo<ScheduleJobEntity> TaskPageList(Pageable pageable);

}
