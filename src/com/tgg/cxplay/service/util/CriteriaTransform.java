package com.tgg.cxplay.service.util;

import com.tgg.cxplay.model.vo.LimitCriteriaVO;
import com.tgg.cxplay.model.vo.UserSearchCriteriaVO;
import com.tgg.cxplay.model.vo.VideoSearchCriteriaVO;
import com.tgg.cxplay.util.StringUtil;

public class CriteriaTransform {

    public static LimitCriteriaVO videoSearchCriteria2LimitCriteriaVO(VideoSearchCriteriaVO vsc) {
        LimitCriteriaVO lc = new LimitCriteriaVO();
        lc.setCurrentPage(vsc.getCurrentPage());
        lc.setPerPageItems(vsc.getPerPageItems());
        if(StringUtil.isNotEmpty(vsc.getOrderBy())) {
            lc.setOrderBy(vsc.getOrderBy());
            lc.setDESC(vsc.isDESC());
        } else {
            lc.setOrderBy(null);
            lc.setDESC(false);
        }
        return lc;
    }
    public static LimitCriteriaVO userSearchCriteria2LimitCriteriaVO(UserSearchCriteriaVO usc) {
        LimitCriteriaVO lc = new LimitCriteriaVO();
        lc.setCurrentPage(usc.getCurrentPage());
        lc.setPerPageItems(usc.getPerPageItems());
        if(StringUtil.isNotEmpty(usc.getOrderBy())) {
            lc.setOrderBy(usc.getOrderBy());
            lc.setDESC(usc.isDESC());
        } else {
            lc.setOrderBy(null);
            lc.setDESC(false);
        }
        return lc;
    }
}
