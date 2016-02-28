package com.tgg.cxplay.exception;

public class XMLException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public XMLException() {
        super();
    }

    public XMLException(String msg) {
        super(msg);
    }

    public XMLException(Throwable cause) {
        super(cause);
    }

    public XMLException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
