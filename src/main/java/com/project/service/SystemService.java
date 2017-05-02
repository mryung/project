package com.project.service;

import java.util.List;

import com.project.entity.project.StartEndTime;

public interface SystemService {
	List<Double> systemByTime(StartEndTime time);
	List<Double> allConsume(List<StartEndTime> timelist);
}
