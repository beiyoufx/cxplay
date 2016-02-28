package com.tgg.cxplay.log;

/** 
 * @ClassName LogFactory
 * @Description LogFactory interface.
 * @author Jerry Teng
 * @date Jul 18, 2015 7:43:05 PM
 */
public interface LogFactory {

    public Log getLog(Class<?> clazz);
    public Log getLog(String name);
    public Log getRootLog();
}
