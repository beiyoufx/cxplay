package com.tgg.cxplay.rest.util;

import java.beans.PropertyEditorSupport;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tgg.cxplay.log.Log;
import com.tgg.cxplay.log.LogFactoryUtil;

/** 
 * @ClassName JsonObjectEditor
 * @Description Transform String to Object.
 * @author Jerry Teng
 * @date Aug 2, 2015 1:01:07 PM
 */
public class JsonObjectEditor extends PropertyEditorSupport {

    public JsonObjectEditor() {
        super();
    }
    public JsonObjectEditor(Class<?> clazz) {
        this._clazz = clazz;
    }

    @Override
    public void setAsText(String json) throws IllegalArgumentException {
        Gson gson = new Gson();
        Object object = null;
        try {
            object = gson.fromJson(json, this._clazz);
            setValue(object);
        } catch(JsonSyntaxException e) {
            log.error(e);
        }
    }

    private Class<?> _clazz;
    private static final Log log = LogFactoryUtil.getLog(JsonObjectEditor.class);
}
