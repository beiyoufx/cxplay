package com.tgg.cxplay.rest.vo;

/** 
 * @ClassName Media
 * @Description Media for RESTful.
 * @author Jerry Teng
 * @date Jul 25, 2015 6:52:02 PM
 */
public class Media {

    private int id;
    private String name;
    private String enName;
    private String createTime;
    private String updateTime;
    private String url;
    private String pic;
    private String clarity;
    private String synopsis;
    private int episode;
    private String actors;
    private String directors;
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
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(String updateTime) {
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

    @Override
    public String toString() {
        return "Media [id=" + id + ",name=" + name 
                + ",enName=" + enName + ",createTime=" + createTime 
                + ",updateTime=" + updateTime + ",url=" + url 
                + ",pic=" + pic + ",clarity=" + clarity 
                + ",synopsis=" + synopsis + ",episode=" + episode 
                + ",actors=" + actors + ",directors=" + directors 
                + ",category=" + category + ",tag=" + tag 
                + ",area=" + area + "]";
    }
}
