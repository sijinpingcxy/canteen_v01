package com.psbc.canteen.common.web.interceptor;

import com.psbc.canteen.common.exception.AppException;
import com.psbc.canteen.common.exception.RenderCommonException;
import com.psbc.canteen.common.exception.RenderJsonException;
import com.psbc.canteen.common.utils.resultUtil.AppResultUtil;
import com.psbc.canteen.common.utils.string.StringUtils;
import com.psbc.canteen.common.enumeration.ErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常拦截器
 *
 * @author zhangdd
 * @ClassName: RenderExceptionInterceptor
 * @create 2019/8/21 16:43
 * @since 1.0.0
 */
@RestControllerAdvice
public class RenderExceptionInterceptor {
    private final static Logger log = LoggerFactory.getLogger(RenderExceptionInterceptor.class);

    public static final ErrorType.ErrorTypeEnum defaultErrorEnum = ErrorType.ErrorTypeEnum.FAILURE;
    public static final int defaultCode = defaultErrorEnum.getCode();
    public static final String defaultMsg = defaultErrorEnum.getMessage();
    public static final String defaultView = "/WEB-INF/exception/500.jsp";

    @ExceptionHandler(Exception.class)
    public Object resloveAndWrite(Exception ex) {
        log.info("捕获到异常："+ex.getMessage());
        if (ex instanceof AppException) {
            AppException appException = (AppException) ex;
            return new AppResultUtil().setCode(appException.getErrorEnum()).setMsg(appException.getMsg());
        } else if (ex instanceof RenderCommonException) {
            RenderCommonException renderCommonException = (RenderCommonException) ex;
            return new AppResultUtil().setCode(renderCommonException.getCode()).setMsg(renderCommonException.getMessage()).setSubCode(renderCommonException.getErrorEnum().getName());
        } else if (ex instanceof RenderJsonException) {
            RenderJsonException renderJsonException = (RenderJsonException) ex;
            return new AppResultUtil().setCode(renderJsonException.getCode()).setMsg(renderJsonException.getMessage()).setSubCode(renderJsonException.getErrorEnum().getName());
        }
        return new AppResultUtil().setCode(defaultErrorEnum).setMsg(StringUtils.isBlank(ex.getMessage()) ? defaultErrorEnum.getMessage() : ex.getMessage());

    }
}