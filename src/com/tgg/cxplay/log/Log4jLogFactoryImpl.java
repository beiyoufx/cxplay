package com.tgg.cxplay.log;

/** 
 * @ClassName Log4jLogFactoryImpl
 * @Description implement LogFactory use third part log4j framework.
 * @author Jerry Teng
 * @date Jul 18, 2015 7:44:03 PM
 */
public class Log4jLogFactoryImpl implements LogFactory {

    @Override
    public Log getLog(Class<?> clazz) {
        return Log4jLog.getLog(clazz);
    }

    @Override
    public Log getLog(String name) {
        return Log4jLog.getLog(name);
    }

    @Override
    public Log getRootLog() {
        return Log4jLog.getRootLog();
    }
}
