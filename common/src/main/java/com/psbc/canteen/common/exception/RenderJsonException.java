package com.psbc.canteen.common.exception;


import com.psbc.canteen.common.web.interceptor.RenderExceptionInterceptor;
import com.psbc.canteen.common.enumeration.ErrorType;

public class RenderJsonException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 6467539566258413908L;

    private int code = RenderExceptionInterceptor.defaultCode;

    private ErrorType.ErrorTypeEnum errorEnum = RenderExceptionInterceptor.defaultErrorEnum;


    public RenderJsonException(String msg) {
        super(msg);
    }

    public RenderJsonException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public RenderJsonException(ErrorType.ErrorTypeEnum errorEnum) {
        super(errorEnum.getMessage());
        this.errorEnum = errorEnum;
        this.code = errorEnum.getCode();
    }

    public ErrorType.ErrorTypeEnum getErrorEnum() {
        return errorEnum;
    }

    public RenderJsonException(String errMsg, Exception e) {
        super(errMsg, e);
    }

    public int getCode() {
        return code;
    }
}
