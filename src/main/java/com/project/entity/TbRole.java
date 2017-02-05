package com.project.entity;

import java.util.Date;

public class TbRole {
    private Integer roleId;

    private Integer roleParentId;

    private String roleParents;

    private String roleName;

    private Date roleGenTime;

    private String roleDescription;

    private String available;

    private String roleCode;

    private Byte sorted;

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

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available == null ? null : available.trim();
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
}