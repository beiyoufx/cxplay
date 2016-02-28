package com.tgg.cxplay.model.vo;

public class UserSearchCriteriaVO {

    private String keywords;
    private String role;
    private int index;
    private int currentPage;
    private int perPageItems;
    private String orderBy;
    private boolean isDESC;

    public String getKeywords() {
        return keywords;
    }
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getPerPageItems() {
        return perPageItems;
    }
    public void setPerPageItems(int perPageItems) {
        this.perPageItems = perPageItems;
    }
    public String getOrderBy() {
        return orderBy;
    }
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
    public boolean isDESC() {
        return isDESC;
    }
    public void setIsDESC(boolean isDESC) {
        this.isDESC = isDESC;
    }
    
    @Override
    public String toString() {
        return "UserSearchCriteriaVO [keywords=" + keywords + ",index=" + index 
                + ",currentPage=" + currentPage + ",perPageItems=" + perPageItems 
                + ",orderBy=" + orderBy + ",isDESC=" + isDESC + "]";
    }

}
