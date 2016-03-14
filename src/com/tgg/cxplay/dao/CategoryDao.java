package com.tgg.cxplay.dao;

import java.util.List;

import com.tgg.cxplay.model.Category;

/** 
 * @ClassName CategoryDao
 * @Description Definition methods for Category CIUD.
 * @author Jerry Teng
 * @date 2015/10/28 10:45:22
 */
public interface CategoryDao {
    public List<Category> find();
    public List<Category> find(String keywords);
    public Category getCategory(int id);
    public Category getCategory(String name);
    public int save(Category Category);
    public int update(Category category);
    public int delete(int id);
}
