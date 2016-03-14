package com.tgg.cxplay.dao.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.tgg.cxplay.util.StringUtil;

/** 
 * @ClassName CustomSQL
 * @Description load custom SQL and handle SQL.
 * @author Jerry Teng
 * @date Jul 16, 2015 9:52:45 PM
 */
public class CustomSQL {

    private Map<String, String> _sqlPool = new HashMap<String, String>();

    public CustomSQL() throws Exception {
        reload();
    }

    public String get(String id) {
        return _sqlPool.get(id);
    }

    public void reload() throws Exception {
        Class< ? > clazz = this.getClass();
        ClassLoader classLoader = clazz.getClassLoader();

        String defaultSource = "custom/custom-sql.xml";

        _sqlPool.clear();
        read(classLoader, defaultSource);
    }

    public void read(ClassLoader classLoader, String source) throws Exception {
        InputStream is = classLoader.getResourceAsStream(source);

        if (is == null) {
            return;
        }

        SAXReader reader = new SAXReader();
        Document document = reader.read(is);

        Element root = document.getRootElement();
        @SuppressWarnings("unchecked")
        List<Element> sqlList = root.elements("sql");
        for (Element sqlElement : sqlList) {
            String file = sqlElement.attributeValue("file");

            if (StringUtil.isNotEmpty(file)) {
                read(classLoader, file);
            } else {
                String id = sqlElement.attributeValue("id");
                String content = sqlElement.getText();
                _sqlPool.put(id, content);
            }
        }
    }

    public String getDefaultOrder() {
        return "ORDER BY update_time DESC";
    }

}
