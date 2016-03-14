package com.tgg.cxplay.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.tgg.cxplay.dao.AreaDao;
import com.tgg.cxplay.exception.EparamError;
import com.tgg.cxplay.exception.ParamException;
import com.tgg.cxplay.log.Log;
import com.tgg.cxplay.log.LogFactoryUtil;
import com.tgg.cxplay.model.Area;
import com.tgg.cxplay.service.AreaService;
import com.tgg.cxplay.util.StringUtil;

public class AreaServiceImpl implements AreaService {
	
    private AreaDao areaDao;
    public void setAreaDao(AreaDao areaDao) {
        this.areaDao = areaDao;
    }
    
	@Override
	public List<Area> find(String keywords) {
		return areaDao.find(keywords);
	}

	@Override
	public Area get(int id) throws ParamException {

		ParamException pe = null;
		if (id == 0) {
			pe = new ParamException(EparamError.AREA_ID_NULL, "Area ID is required");
			throw pe;
		}
		return areaDao.getArea(id);
	}

	@Override
	public Area get(String name) throws ParamException {

		ParamException pe = null;
		if (StringUtil.isEmpty(name)) {
			pe = new ParamException(EparamError.AREA_NAME_NULL, "Area Name is required");
			throw pe;
		}
		return areaDao.getArea(name);
	}

	@Override
	public Area get(Area area) {
		
		if (area != null) {
			if (area.getId() != 0) {
				area = areaDao.getArea(area.getId());
			} else if (StringUtil.isNotEmpty(area.getName())) {
				area = areaDao.getArea(area.getName());
			}
		}
		return area;
	}

	@Override
	public List<Area> find() {
		return areaDao.find();
	}

	@Override
	public List<Area> find(int[] ids) throws ParamException {
		
		List<Area> areas = new ArrayList<Area>();
		for (int id : ids) {
			Area area = get(id);
			if (area != null) {
				areas.add(area);
			}
		}
		return areas;
	}

	@Override
	public boolean update(Area area) {

		int status = areaDao.update(area);
		if (status == 0) {
			log.error("Update Area Error: Cannot update the area, [id:" + area.getId() + "]");
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(int id) {

		int status = areaDao.delete(id);
		if (status == 0) {
			log.error("Delete Area Error: Cannot delete the area, [id:" + id + "]");
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

	@Override
	public int save(Area area) throws ParamException {

		ParamException pe = null;
		if (area == null) {
			pe = new ParamException(EparamError.AREA_NULL, "Area is required");
			throw pe;
		}
		if (area.getId() == 0) {
			pe = new ParamException(EparamError.AREA_ID_NULL, "Area ID is required");
			throw pe;
		}
		if (StringUtil.isEmpty(area.getName())) {
			pe = new ParamException(EparamError.AREA_NAME_NULL, "Area Name is required");
			throw pe;
		}
		if (StringUtil.isEmpty(area.getDisplayName())) {
			area.setDisplayName(area.getName());
		}
		return areaDao.save(area);
	}

	private static final Log log = LogFactoryUtil.getLog(AreaService.class);
}
