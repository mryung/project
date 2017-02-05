package com.project.entity;

import java.util.Date;

public class TbLog {
    private Integer logId;

    private Integer logOperateType;

    private String logOperateContent;

    private Integer logOperateUserId;

    private Date logOperateTime;

    private Date logTime;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getLogOperateType() {
        return logOperateType;
    }

    public void setLogOperateType(Integer logOperateType) {
        this.logOperateType = logOperateType;
    }

    public String getLogOperateContent() {
        return logOperateContent;
    }

    public void setLogOperateContent(String logOperateContent) {
        this.logOperateContent = logOperateContent == null ? null : logOperateContent.trim();
    }

    public Integer getLogOperateUserId() {
        return logOperateUserId;
    }

    public void setLogOperateUserId(Integer logOperateUserId) {
        this.logOperateUserId = logOperateUserId;
    }

    public Date getLogOperateTime() {
        return logOperateTime;
    }

    public void setLogOperateTime(Date logOperateTime) {
        this.logOperateTime = logOperateTime;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }
}