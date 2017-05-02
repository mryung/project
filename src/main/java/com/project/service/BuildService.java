package com.project.service;

import java.util.List;

import com.project.entity.project.StartEndTime;

public interface BuildService {
	
	//所有这段时间类楼层的消耗
	List<Double> allBuildConsumeList(StartEndTime time);
	List<Double> buildByTime(List<StartEndTime> timeList, int elementname);
}
