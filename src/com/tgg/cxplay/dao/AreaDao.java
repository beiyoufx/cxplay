package com.tgg.cxplay.dao;

import java.util.List;

import com.tgg.cxplay.model.Area;

/** 
 * @ClassName AreaDao
 * @Description Definition methods for Area CIUD.
 * @author Jerry Teng
 * @date 2015/10/28 10:45:22
 */
public interface AreaDao {
    public List<Area> find();
    public List<Area> find(String keywords);
    public Area getArea(int id);
    public Area getArea(String name);
    public int save(Area area);
    public int update(Area area);
    public int delete(int id);
}
