package com.project.entity;

public class TbRight {
    private Integer rightId;

    private Integer rightParentId;

    private String rightParents;

    private String rightName;

    private String rightUrl;

    private String rightDescription;

    private String rightCode;

    private Integer available;

    private Integer sorted;

    private Byte isShow;

    public Integer getRightId() {
        return rightId;
    }

    public void setRightId(Integer rightId) {
        this.rightId = rightId;
    }

    public Integer getRightParentId() {
        return rightParentId;
    }

    public void setRightParentId(Integer rightParentId) {
        this.rightParentId = rightParentId;
    }

    public String getRightParents() {
        return rightParents;
    }

    public void setRightParents(String rightParents) {
        this.rightParents = rightParents == null ? null : rightParents.trim();
    }

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName == null ? null : rightName.trim();
    }

    public String getRightUrl() {
        return rightUrl;
    }

    public void setRightUrl(String rightUrl) {
        this.rightUrl = rightUrl == null ? null : rightUrl.trim();
    }

    public String getRightDescription() {
        return rightDescription;
    }

    public void setRightDescription(String rightDescription) {
        this.rightDescription = rightDescription == null ? null : rightDescription.trim();
    }

    public String getRightCode() {
        return rightCode;
    }

    public void setRightCode(String rightCode) {
        this.rightCode = rightCode == null ? null : rightCode.trim();
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Integer getSorted() {
        return sorted;
    }

    public void setSorted(Integer sorted) {
        this.sorted = sorted;
    }

    public Byte getIsShow() {
        return isShow;
    }

    public void setIsShow(Byte isShow) {
        this.isShow = isShow;
    }
}