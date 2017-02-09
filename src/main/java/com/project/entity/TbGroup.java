package com.project.entity;

import java.util.Date;

public class TbGroup {
    private Integer groupId;

    private String groupName;

    private Integer groupParentId;

    private String groupParents;

    private Date groupGenTime;

    private String groupDescription;

    private Integer available;

    private String groupCode;

    private Byte sorted;

    private Integer deleted;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public Integer getGroupParentId() {
        return groupParentId;
    }

    public void setGroupParentId(Integer groupParentId) {
        this.groupParentId = groupParentId;
    }

    public String getGroupParents() {
        return groupParents;
    }

    public void setGroupParents(String groupParents) {
        this.groupParents = groupParents == null ? null : groupParents.trim();
    }

    public Date getGroupGenTime() {
        return groupGenTime;
    }

    public void setGroupGenTime(Date groupGenTime) {
        this.groupGenTime = groupGenTime;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription == null ? null : groupDescription.trim();
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode == null ? null : groupCode.trim();
    }

    public Byte getSorted() {
        return sorted;
    }

    public void setSorted(Byte sorted) {
        this.sorted = sorted;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}