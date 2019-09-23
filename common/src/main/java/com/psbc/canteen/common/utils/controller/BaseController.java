package com.psbc.canteen.common.utils.controller;

import com.psbc.canteen.common.utils.InterfacePage;
import com.psbc.canteen.common.utils.resultUtil.AppResultUtil;
import com.psbc.canteen.common.utils.resultUtil.ResultUtil;
import com.psbc.canteen.common.enumeration.ErrorType;

/**
 * 类BaseController.java的实现描述：controller自定义基类 增加了存放在redis中的JSession 基本的json返回格式
 * 
 * @author zhangdd
 */
public class BaseController{

	//后端相关返回结果
	public ResultUtil renderOK() {
		return new ResultUtil().setCode(ErrorType.ErrorTypeEnum.SUCCESS);
	}
	public ResultUtil renderOK(String msg) {
		return new ResultUtil().setCode(ErrorType.ErrorTypeEnum.SUCCESS).setMsg(msg);
	}

	public ResultUtil renderDataOK(Object data) {
		return new ResultUtil().setCode(ErrorType.ErrorTypeEnum.SUCCESS).setData(data);
	}

	public ResultUtil renderOK(Object data, InterfacePage page) {
		return new ResultUtil().setCode(ErrorType.ErrorTypeEnum.SUCCESS).setData(data).setPage(page);
	}

	public ResultUtil renderPageOK(InterfacePage page) {
		return new ResultUtil().setCode(ErrorType.ErrorTypeEnum.SUCCESS).setData(page.getList()).setPage(page);
	}

	public ResultUtil renderOK(ResultUtil resultUtil) {
		return resultUtil.setCode(ErrorType.ErrorTypeEnum.SUCCESS);
	}

	public ResultUtil renderFail() {
		return new ResultUtil().setCode(ErrorType.ErrorTypeEnum.FAILURE);
	}

	//APP接口相关返回结果
	public AppResultUtil renderAppOK() {
		return new AppResultUtil().setCode(ErrorType.ErrorTypeEnum.SUCCESS);
	}
	public AppResultUtil renderAppOK(String msg) {
		return new AppResultUtil().setCode(ErrorType.ErrorTypeEnum.SUCCESS).setMsg(msg);
	}
	public AppResultUtil renderAppDataOK(Object data) {
		return new AppResultUtil().setCode(ErrorType.ErrorTypeEnum.SUCCESS).setData(data);
	}

	public AppResultUtil renderAppOK(AppResultUtil resultUtil) {
		return resultUtil.setCode(ErrorType.ErrorTypeEnum.SUCCESS);
	}

	public AppResultUtil renderAppFail() {
		return new AppResultUtil().setCode(ErrorType.ErrorTypeEnum.FAILURE);
	}

	public AppResultUtil renderAppFail(String msg) {
		return new AppResultUtil().setCode(ErrorType.ErrorTypeEnum.FAILURE).setMsg(msg);
	}

	public AppResultUtil renderAppFail(ErrorType.ErrorTypeEnum errorTypeEnum) {
		return new AppResultUtil().setCode(errorTypeEnum);
	}


}
