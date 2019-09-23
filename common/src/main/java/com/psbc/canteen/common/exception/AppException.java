package com.psbc.canteen.common.exception;


import com.psbc.canteen.common.web.interceptor.RenderExceptionInterceptor;
import com.psbc.canteen.common.enumeration.ErrorType;

/**
 * 自定义异常
 * @author yangsl
 */
public class AppException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 4715845397162973563L;


    private ErrorType.ErrorTypeEnum errorEnum = RenderExceptionInterceptor.defaultErrorEnum;;

    private int code = RenderExceptionInterceptor.defaultCode;

    private String msg = RenderExceptionInterceptor.defaultMsg;

    public AppException(ErrorType.ErrorTypeEnum errorEnum) {
        this(errorEnum.getMessage());
        this.errorEnum = errorEnum;
        this.code = errorEnum.getCode();
    }



    public AppException(String errMsg) {
        super(errMsg);
        this.msg = errMsg;

    }

    public AppException(String errMsg, Exception e) {
        super(errMsg, e);
    }

    public ErrorType.ErrorTypeEnum getErrorEnum() {
        return errorEnum;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

}
