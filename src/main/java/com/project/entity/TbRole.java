package com.project.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TbRole {
    private Integer roleId;

    private Integer roleParentId;

    private String roleParents;

    private String roleName;
    
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date roleGenTime;

    private String roleDescription;

    private Integer available;

    private String roleCode;

    private Byte sorted;

    private Integer deleted;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRoleParentId() {
        return roleParentId;
    }

    public void setRoleParentId(Integer roleParentId) {
        this.roleParentId = roleParentId;
    }

    public String getRoleParents() {
        return roleParents;
    }

    public void setRoleParents(String roleParents) {
        this.roleParents = roleParents == null ? null : roleParents.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Date getRoleGenTime() {
        return roleGenTime;
    }

    public void setRoleGenTime(Date roleGenTime) {
        this.roleGenTime = roleGenTime;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription == null ? null : roleDescription.trim();
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
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