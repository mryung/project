package com.project.service;

import com.project.entity.project.StartEndTime;

public interface CommonService {
	double totalBuild(StartEndTime time);
	double totalTransfomer(StartEndTime time);
}
