package com.tgg.cxplay.model.vo;

public class VideoSearchCriteriaVO {

    private String keywords;
    private String category;
    private String tag;
    private String area;
    private int index;
    private int currentPage;
    private int perPageItems;
    private String orderBy;
    private boolean isDESC;

    public String getKeyword() {
        return keywords;
    }
    public void setKeyword(String keyword) {
        this.keywords = keyword;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
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
        return "VideoSearchCriteriaVO [keywords=" + keywords + ",category=" + category 
                + ",tag=" + tag + ",area=" + area 
                + ",index=" + index + ",currentPage=" + currentPage 
                + ",perPageItems=" + perPageItems + ",orderBy=" + orderBy 
                + ",isDESC=" + isDESC + "]";
    }

}
