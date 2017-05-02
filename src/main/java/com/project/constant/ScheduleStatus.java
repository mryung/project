package com.project.constant;

/**
 * 
 * @projectNam hisdb
 * @classname  ScheduleStatus
 * @<p>description: 任务状态类</p>
 * @email     2327542415@qq.com
 * @date       2017年3月16日:下午7:09:49
 * @version    0.0.1
 *
 */
public enum ScheduleStatus {
	 /**
     * 正常
     */
	NORMAL(0),
    /**
     * 暂停
     */
	PAUSE(1);
	
	private int value;
	private ScheduleStatus(int value) {
		this.value  = value;
	}
	
	 public int getValue() {
         return value;
     }
}
