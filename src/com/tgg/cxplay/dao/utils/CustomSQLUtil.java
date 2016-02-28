package com.tgg.cxplay.dao.utils;

import com.tgg.cxplay.exception.XMLException;

/** 
 * @ClassName CustomSQLUtil
 * @Description Parse xml to get custom sql.
 * @author Jerry Teng
 * @date Jul 12, 2015 5:35:01 PM
 */
public class CustomSQLUtil {

    public static String get(String id) {
        return _instance._customSQL.get(id);
    }
    public static String getDefaultOrder() {
        return _instance._customSQL.getDefaultOrder();
    }

    private CustomSQLUtil() {
        try {
            _customSQL = new CustomSQL();
        } catch (Exception e) {
            throw new XMLException(e);
        }
    }

    private static CustomSQLUtil _instance = new CustomSQLUtil();
    private CustomSQL _customSQL;

}
