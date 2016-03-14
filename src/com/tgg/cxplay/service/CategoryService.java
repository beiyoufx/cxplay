package com.tgg.cxplay.service;

import java.util.List;

import com.tgg.cxplay.exception.ParamException;
import com.tgg.cxplay.model.Category;

public interface CategoryService {

	public List<Category> find();
	public List<Category> find(int[] ids) throws ParamException;
	public List<Category> find(String keywords);
	public Category get(int id) throws ParamException;
	public Category get(String name) throws ParamException;
	public Category get(Category category) throws ParamException;
    public int save(Category category) throws ParamException;
    public boolean update(Category category) throws ParamException;
    public boolean delete(int id);
    public boolean delete(int[] ids);
}
