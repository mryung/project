package com.project.entity;

public class StartEndTime {
	private Long startTime;
	private Long endTime;
	
	
	public StartEndTime(Long startTime, Long endTime) {
		this.startTime = startTime/1000;
		this.endTime = endTime/1000;
	}
	
	public StartEndTime() {
	}

	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	
	
}
