package com.psbc.canteen.common.exception;


import com.psbc.canteen.common.web.interceptor.RenderExceptionInterceptor;
import com.psbc.canteen.common.enumeration.ErrorType;

/**
 * 通用异常，由拦截器自动判断返回类型（json / view）
 * @author huangkang
 */
public class RenderCommonException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String view = RenderExceptionInterceptor.defaultView;

    private int code = RenderExceptionInterceptor.defaultCode;

    private ErrorType.ErrorTypeEnum errorEnum = RenderExceptionInterceptor.defaultErrorEnum;

    public RenderCommonException(String msg, String view) {
        super(msg);
        this.view = view;
    }

    public RenderCommonException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public RenderCommonException(String msg) {
        super(msg);
    }

    public RenderCommonException(ErrorType.ErrorTypeEnum codeEnum) {
        super(codeEnum.getMessage());
        this.errorEnum = codeEnum;
        this.code = Integer.valueOf(codeEnum.getCode());
    }

    public ErrorType.ErrorTypeEnum getErrorEnum() {
        return errorEnum;
    }

    public RenderCommonException(String errMsg, Exception e) {
        super(errMsg, e);
    }

    public String getView() {
        return view;
    }

    public int getCode() {
        return code;
    }
}
