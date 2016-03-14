package com.tgg.cxplay.model;

public class Area {

    private int id;
    private String name;
    private String displayName;

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
    
    @Override
    public String toString() {
        return "Area [id=" + id + ",name=" + name + "]";
    }

}
