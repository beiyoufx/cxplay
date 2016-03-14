package com.tgg.cxplay.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.tgg.cxplay.dao.TagDao;
import com.tgg.cxplay.exception.EparamError;
import com.tgg.cxplay.exception.ParamException;
import com.tgg.cxplay.log.Log;
import com.tgg.cxplay.log.LogFactoryUtil;
import com.tgg.cxplay.model.Tag;
import com.tgg.cxplay.service.TagService;
import com.tgg.cxplay.util.StringUtil;

public class TagServiceImpl implements TagService {

	private TagDao tagDao;
    public void setTagDao(TagDao tagDao) {
        this.tagDao = tagDao;
    }
	
	@Override
	public List<Tag> find() {
		return tagDao.find();
	}

	@Override
	public List<Tag> find(int[] ids) throws ParamException {
		
		List<Tag> tags = new ArrayList<Tag>();
		for (int id : ids) {
			Tag tag = get(id);
			if (tag != null) {
				tags.add(tag);
			}
		}
		return tags;
	}

	@Override
	public List<Tag> find(String keywords) {
		return tagDao.find(keywords);
	}

	@Override
	public Tag get(int id) throws ParamException {
		
		ParamException pe = null;
		if (id == 0) {
			pe = new ParamException(EparamError.TAG_ID_NULL, "Tag ID is required");
			throw pe;
		}
		return tagDao.getTag(id);
	}

	@Override
	public Tag get(String name) throws ParamException {
		
		ParamException pe = null;
		if (StringUtil.isEmpty(name)) {
			pe = new ParamException(EparamError.TAG_NAME_NULL, "Tag Name is required");
			throw pe;
		}
		return tagDao.getTag(name);
	}

	@Override
	public Tag get(Tag tag) throws ParamException {
		
		if (tag != null) {
			if (tag.getId() != 0) {
				tag = tagDao.getTag(tag.getId());
			} else if (StringUtil.isNotEmpty(tag.getName())) {
				tag = tagDao.getTag(tag.getName());
			}
		}
		return tag;
	}

	@Override
	public int save(Tag tag) throws ParamException {

		ParamException pe = null;
		if (tag == null) {
			pe = new ParamException(EparamError.TAG_NULL, "Tag is required");
			throw pe;
		}
		if (tag.getId() == 0) {
			pe = new ParamException(EparamError.TAG_ID_NULL, "Tag ID is required");
			throw pe;
		}
		if (StringUtil.isEmpty(tag.getName())) {
			pe = new ParamException(EparamError.TAG_NAME_NULL, "Tag Name is required");
			throw pe;
		}
		if (StringUtil.isEmpty(tag.getDisplayName())) {
			tag.setDisplayName(tag.getName());
		}
		return tagDao.save(tag);
	}

	@Override
	public boolean update(Tag tag) {
		
		int status = tagDao.update(tag);
		if (status == 0) {
			log.error("Update Tag Error: Cannot update the tag, [id:" + tag.getId() + "]");
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(int id) {
		
		int status = tagDao.delete(id);
		if (status == 0) {
			log.error("Delete Tag Error: Cannot delete the tag, [id:" + id + "]");
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(int[] ids) {
		
		boolean status = true;
		for (int id : ids) {
			status = delete(id);
		}
		return status;
	}
	
	private static final Log log = LogFactoryUtil.getLog(TagService.class);
}
