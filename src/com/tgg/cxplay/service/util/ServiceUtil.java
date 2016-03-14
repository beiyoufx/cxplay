package com.tgg.cxplay.service.util;

import org.springframework.stereotype.Service;

import com.tgg.cxplay.service.AreaService;
import com.tgg.cxplay.service.CategoryService;
import com.tgg.cxplay.service.TagService;

@Service
public class ServiceUtil {

	public static TagService getTagService() {
		return _tagService;
	}

	public void setTagService(TagService tagService) {
		_tagService = tagService;
	}
	
	public static AreaService getAreaService() {
		return _areaService;
	}
	
	public void setAreaService(AreaService areaService) {
		_areaService = areaService;
	}
	
	public static CategoryService getCategoryService() {
		return _categoryService;
	}
	
	public void setCategoryService(CategoryService categoryService) {
		_categoryService = categoryService;
	}
	
	private static TagService _tagService;
	private static AreaService _areaService;
	private static CategoryService _categoryService;
}
