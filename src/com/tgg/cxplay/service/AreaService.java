package com.tgg.cxplay.service;

import java.util.List;

import com.tgg.cxplay.exception.ParamException;
import com.tgg.cxplay.model.Area;

public interface AreaService {

	public List<Area> find();
	public List<Area> find(int[] ids) throws ParamException;
	public List<Area> find(String keywords);
	public Area get(int id) throws ParamException;
	public Area get(String name) throws ParamException;
	public Area get(Area area) throws ParamException;
    public int save(Area area) throws ParamException;
    public boolean update(Area area);
    public boolean delete(int id);
    public boolean delete(int[] ids);
}
