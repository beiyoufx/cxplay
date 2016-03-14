package com.tgg.cxplay.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.tgg.cxplay.dao.CategoryDao;
import com.tgg.cxplay.exception.EparamError;
import com.tgg.cxplay.exception.ParamException;
import com.tgg.cxplay.log.Log;
import com.tgg.cxplay.log.LogFactoryUtil;
import com.tgg.cxplay.model.Category;
import com.tgg.cxplay.service.CategoryService;
import com.tgg.cxplay.util.StringUtil;

public class CategoryServiceImpl implements CategoryService {

	private CategoryDao categoryDao;
    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }
	
	@Override
	public List<Category> find() {
		return categoryDao.find();
	}

	@Override
	public List<Category> find(int[] ids) throws ParamException {

		List<Category> categories = new ArrayList<Category>();
		for (int id : ids) {
			Category category = get(id);
			if (category != null) {
				categories.add(category);
			}
		}
		return categories;
	}

	@Override
	public List<Category> find(String keywords) {
		return categoryDao.find(keywords);
	}

	@Override
	public Category get(int id) throws ParamException {

		ParamException pe = null;
		if (id == 0) {
			pe = new ParamException(EparamError.CATEGORY_ID_NULL, "Category ID is required");
			throw pe;
		}
		return categoryDao.getCategory(id);
	}

	@Override
	public Category get(String name) throws ParamException {

		ParamException pe = null;
		if (StringUtil.isEmpty(name)) {
			pe = new ParamException(EparamError.CATEGORY_NAME_NULL, "Category Name is required");
			throw pe;
		}
		return categoryDao.getCategory(name);
	}

	@Override
	public Category get(Category category) {

		if (category != null) {
			if (category.getId() != 0) {
				category = categoryDao.getCategory(category.getId());
			} else if (StringUtil.isNotEmpty(category.getName())) {
				category = categoryDao.getCategory(category.getName());
			}
		}
		return category;
	}

	@Override
	public int save(Category category) throws ParamException {

		ParamException pe = null;
		if (category == null) {
			pe = new ParamException(EparamError.CATEGORY_NULL, "Category is required");
			throw pe;
		}
		if (category.getId() == 0) {
			pe = new ParamException(EparamError.CATEGORY_ID_NULL, "Category ID is required");
			throw pe;
		}
		if (StringUtil.isEmpty(category.getName())) {
			pe = new ParamException(EparamError.CATEGORY_NAME_NULL, "Category Name is required");
			throw pe;
		}
		if (StringUtil.isEmpty(category.getDisplayName())) {
			category.setDisplayName(category.getName());
		}
		return categoryDao.save(category);
	}

	@Override
	public boolean update(Category category) {

		int status = categoryDao.update(category);
		if (status == 0) {
			log.error("Update Category Error: Cannot update the category, [id:" + category.getId() + "]");
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(int id) {
		
		int status = categoryDao.delete(id);
		if (status == 0) {
			log.error("Delete Category Error: Cannot delete the category, [id:" + id + "]");
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

	private static final Log log = LogFactoryUtil.getLog(CategoryService.class);
}
