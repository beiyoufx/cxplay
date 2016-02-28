package com.tgg.cxplay.exception;

public class ORMException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public ORMException() {
        super();
    }

    public ORMException(String msg) {
        super(msg);
    }

    public ORMException(Throwable cause) {
        super(cause);
    }

    public ORMException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
