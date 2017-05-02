package com.project.service;

import java.util.List;

public interface StatisticsService {

	List<Double> statisticsThroughFloor(int flag);

	List<Double> statisticsThroughSystem(int flag);

	double allStatistics(Long startTime, Long endTime);

	List<Double> statisticsThroughFloor(Long startTime, Long endTime);

}
