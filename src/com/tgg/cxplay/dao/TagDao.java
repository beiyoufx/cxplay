package com.tgg.cxplay.dao;

import java.util.List;

import com.tgg.cxplay.model.Tag;

/** 
 * @ClassName TagDao
 * @Description Definition methods for tag CIUD.
 * @author Jerry Teng
 * @date 2015/10/28 10:45:22
 */
public interface TagDao {
    public List<Tag> find();
    public List<Tag> find(String keywords);
    public Tag getTag(int id);
    public Tag getTag(String name);
    public int save(Tag tag);
    public int update(Tag tag);
    public int delete(int id);
}
