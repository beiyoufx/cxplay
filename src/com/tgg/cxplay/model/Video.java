package com.tgg.cxplay.model;

import java.util.Date;

import com.tgg.cxplay.model.vo.VideoVO;


/** 
 * @ClassName VideoAsset
 * @Description all video information in this Asset, for video management.
 * @author Jerry Teng
 * @date Jul 25, 2015 6:49:13 PM
 */
public class Video {

    private int id;
    private String name;
    private String enName;
    private Date createTime;
    private Date updateTime;
    private String url;
    private String pic;
    private String clarity;
    private String synopsis;
    private int episode;
    private String actors;
    private String directors;
    private boolean isDeleted;
    private String category;
    private String tag;
    private String area;

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
    public String getEnName() {
        return enName;
    }
    public void setEnName(String enName) {
        this.enName = enName;
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
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getPic() {
        return pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }
    public String getClarity() {
        return clarity;
    }
    public void setClarity(String clarity) {
        this.clarity = clarity;
    }
    public String getSynopsis() {
        return synopsis;
    }
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
    public int getEpisode() {
        return episode;
    }
    public void setEpisode(int episode) {
        this.episode = episode;
    }
    public String getActors() {
        return actors;
    }
    public void setActors(String actors) {
        this.actors = actors;
    }
    public String getDirectors() {
        return directors;
    }
    public void setDirectors(String directors) {
        this.directors = directors;
    }
    public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
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
    public void setArea(String areaName) {
        this.area = areaName;
    }
    public VideoVO getVideoVO() {
    	VideoVO videoVO = new VideoVO();
    	videoVO.setId(this.getId());
    	videoVO.setActors(this.getActors());
    	videoVO.setClarity(this.getClarity());
    	videoVO.setCreateTime(this.getCreateTime());
    	videoVO.setUpdateTime(this.getUpdateTime());
    	videoVO.setDirectors(this.getDirectors());
    	videoVO.setEnName(this.getEnName());
    	videoVO.setEpisode(this.getEpisode());
    	videoVO.setName(this.getName());
    	videoVO.setPic(this.getPic());
    	videoVO.setSynopsis(this.getSynopsis());
    	videoVO.setUrl(this.getUrl());
    	return videoVO;
    }

    @Override
    public String toString() {
        return "Video [id=" + id + ",name=" + name 
                + ",enName=" + enName + ",createTime=" + createTime.getTime() 
                + ",updateTime=" + updateTime.getTime() + ",url=" + url 
                + ",pic=" + pic + ",clarity=" + clarity 
                + ",synopsis=" + synopsis + ",episode=" + episode 
                + ",actors=" + actors + ",directors=" + directors 
                + ",isDeleted=" + isDeleted
                + ",category=" + category + ",tag=" + tag 
                + ",area=" + area + "]";
    }
}
