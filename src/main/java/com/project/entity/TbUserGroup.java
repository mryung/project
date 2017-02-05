package com.project.entity;

public class TbUserGroup {
    private Integer userGroupId;

    private Integer tbUserId;

    private Integer tbGroupId;

    public Integer getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }

    public Integer getTbUserId() {
        return tbUserId;
    }

    public void setTbUserId(Integer tbUserId) {
        this.tbUserId = tbUserId;
    }

    public Integer getTbGroupId() {
        return tbGroupId;
    }

    public void setTbGroupId(Integer tbGroupId) {
        this.tbGroupId = tbGroupId;
    }
}