package com.tgg.cxplay.service;

import java.util.List;

import com.tgg.cxplay.exception.ParamException;
import com.tgg.cxplay.model.Tag;

public interface TagService {

	public List<Tag> find();
	public List<Tag> find(int[] ids) throws ParamException;
	public List<Tag> find(String keywords);
	public Tag get(int id) throws ParamException;
	public Tag get(String name) throws ParamException;
	public Tag get(Tag tag) throws ParamException;
    public int save(Tag tag) throws ParamException;
    public boolean update(Tag tag);
    public boolean delete(int id);
    public boolean delete(int[] ids);
}
