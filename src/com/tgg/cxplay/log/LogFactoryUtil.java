package com.tgg.cxplay.log;

/** 
 * @ClassName LogFactoryUtil
 * @Description privode Log.
 * @author Jerry Teng
 * @date Jul 18, 2015 7:46:31 PM
 */
public class LogFactoryUtil {

    public static Log getLog(Class<?> clazz) {
        return _instance._logFactory.getLog(clazz);
    }

    public static Log getLog(String name) {
        return _instance._logFactory.getLog(name);
    }

    public static Log getRootLog() {
        return _instance._logFactory.getRootLog();
    }

    private LogFactoryUtil() {
        _logFactory = new Log4jLogFactoryImpl();
    }
    private static LogFactoryUtil _instance = new LogFactoryUtil();
    private LogFactory _logFactory;
}
