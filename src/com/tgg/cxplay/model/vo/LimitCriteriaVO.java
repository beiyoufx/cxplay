package com.tgg.cxplay.model.vo;

public class LimitCriteriaVO {

    private int currentPage;
    private int perPageItems;
    private int totalItems;
    private String orderBy;
    private boolean isDESC;

    public int getIndex() {
        return (currentPage - 1) * perPageItems + 1;
    }
    public int getCurrentPage() {
    	if (currentPage > (totalItems - 1) / perPageItems + 1) {
    		currentPage = (totalItems - 1) / perPageItems + 1;
    	}
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
    public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
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
