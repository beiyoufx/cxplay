package com.tgg.cxplay.model.vo;

public class LimitCriteriaVO {

    private int index;
    private int currentPage;
    private int perPageItems;
    private String orderBy;
    private boolean isDESC;

    public int getIndex() {
        index = (currentPage - 1) * perPageItems;
        return index;
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
    public void setDESC(boolean isDESC) {
        this.isDESC = isDESC;
    }

}
