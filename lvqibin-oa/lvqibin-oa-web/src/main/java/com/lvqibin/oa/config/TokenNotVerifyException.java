package com.lvqibin.oa.config;

public class TokenNotVerifyException extends Exception{
	/**
	 * Token 未通过校验 的异常
	 */
	private static final long serialVersionUID = 1L;
	private int value;
    public TokenNotVerifyException() {
        super();
    }
    public TokenNotVerifyException(String msg,int value) {
        super(msg);
        this.value=value;
    }
    public int getValue() {
        return value;
    }
    
}
