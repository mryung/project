package com.project.entity;

public class TbUserRight {
    private Integer userRightId;

    private Integer userId;

    private Integer rightId;

    private Integer rightType;

    public Integer getUserRightId() {
        return userRightId;
    }

    public void setUserRightId(Integer userRightId) {
        this.userRightId = userRightId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRightId() {
        return rightId;
    }

    public void setRightId(Integer rightId) {
        this.rightId = rightId;
    }

    public Integer getRightType() {
        return rightType;
    }

    public void setRightType(Integer rightType) {
        this.rightType = rightType;
    }
}