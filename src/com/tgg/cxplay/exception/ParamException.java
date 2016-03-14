package com.tgg.cxplay.exception;

public class ParamException extends Exception {
	
	private static final long serialVersionUID = -8037480218763029390L;

	public ParamException() {
        super();
    }

    public ParamException(EparamError code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    
    public EparamError getCode() {
		return code;
	}

	public void setCode(EparamError code) {
		this.code = code;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return "数据异常：异常类型[" + code + "]，信息[" + msg + "]";
	}
	
	private EparamError code;
    private String msg;
}
