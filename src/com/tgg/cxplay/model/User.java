package com.tgg.cxplay.model;

import java.util.Date;

public class User {

    private int id;
    private String name;
    private String displayName;
    private String password;
    private Date createTime;
    private Date updateTime;
    private boolean isDeleted;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public boolean getIsDeleted() {
        return isDeleted;
    }
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ",name=" + name 
                + ",displayName=" + displayName + ",password=" + password 
                + ",createTime=" + createTime.getTime() + ",updateTime=" + updateTime.getTime() 
                + ",isDeleted=" + isDeleted + "]";
    }

}
