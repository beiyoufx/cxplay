package com.tgg.cxplay.rest.vo;

import java.util.List;

public class PagerVO {

    private int index;
    private int currentPage;
    private int perPageItems;
    private int totalPages;
    private int totalItems;
    private List<Media> mediaList;

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
    public int getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    public int getTotalItems() {
        return totalItems;
    }
    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }
    public List<Media> getMediaList() {
        return mediaList;
    }
    public void setMediaList(List<Media> mediaList) {
        this.mediaList = mediaList;
    }
}
