package com.project.entity;

import java.util.Date;

public class TbOrganization {
    private Integer orgId;

    private Integer orgParentId;

    private String orgName;

    private Date orgGenTime;

    private String orgDescription;

    private String orgParents;

    private Byte available;

    private String orgCode;

    private Integer deleted;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getOrgParentId() {
        return orgParentId;
    }

    public void setOrgParentId(Integer orgParentId) {
        this.orgParentId = orgParentId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public Date getOrgGenTime() {
        return orgGenTime;
    }

    public void setOrgGenTime(Date orgGenTime) {
        this.orgGenTime = orgGenTime;
    }

    public String getOrgDescription() {
        return orgDescription;
    }

    public void setOrgDescription(String orgDescription) {
        this.orgDescription = orgDescription == null ? null : orgDescription.trim();
    }

    public String getOrgParents() {
        return orgParents;
    }

    public void setOrgParents(String orgParents) {
        this.orgParents = orgParents == null ? null : orgParents.trim();
    }

    public Byte getAvailable() {
        return available;
    }

    public void setAvailable(Byte available) {
        this.available = available;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}