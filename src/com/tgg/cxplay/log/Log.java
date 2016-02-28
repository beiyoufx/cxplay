package com.tgg.cxplay.log;

/** 
 * @ClassName Log
 * @Description Log base.
 * @author Jerry Teng
 * @date Jul 18, 2015 7:03:27 PM
 */
public abstract class Log{

    public abstract void debug(Object message);
    public abstract void debug(Object message, Throwable t);
    public abstract void info(Object message);
    public abstract void info(Object message, Throwable t);
    public abstract void error(Object message);
    public abstract void error(Object message, Throwable t);
    public abstract void warn(Object message);
    public abstract void warn(Object message, Throwable t);
    public abstract boolean isDebugEnabled();
}
