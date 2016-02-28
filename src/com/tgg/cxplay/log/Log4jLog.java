package com.tgg.cxplay.log;

import org.apache.log4j.Logger;

/** 
 * @ClassName Log4jLog
 * @Description extends Log and add getLog().
 *              use log4j to implement log.
 * @author Jerry Teng
 * @date Jul 18, 2015 7:04:23 PM
 */
public class Log4jLog extends Log {

    public static Log getLog(Class<?> clazz) {
        return new Log4jLog(clazz);
    }

    public static Log getLog(String name) {
        return new Log4jLog(name);
    }

    public static Log getRootLog() {
        return new Log4jLog();
    }

    @Override
    public void debug(Object message) {
        _logger.debug(message);
    }

    @Override
    public void debug(Object message, Throwable t) {
        _logger.debug(message, t);
    }

    @Override
    public void info(Object message) {
        _logger.info(message);
    }

    @Override
    public void info(Object message, Throwable t) {
        _logger.info(message, t);
    }

    @Override
    public void error(Object message) {
        _logger.error(message);
    }

    @Override
    public void error(Object message, Throwable t) {
        _logger.error(message, t);
    }

    @Override
    public void warn(Object message) {
        _logger.warn(message);
    }

    @Override
    public void warn(Object message, Throwable t) {
        _logger.warn(message, t);
    }

    @Override
    public boolean isDebugEnabled() {
        return _logger.isDebugEnabled();
    }

    private Log4jLog(Class<?> clazz) {
        _logger = Logger.getLogger(clazz);
    }

    private Log4jLog(String name) {
        _logger = Logger.getLogger(name);
    }

    private Log4jLog() {
        _logger = Logger.getRootLogger();
    }

    private Logger _logger;
}
