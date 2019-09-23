package com.psbc.canteen.common.utils.resultUtil;



import com.psbc.canteen.common.utils.date.DateUtils;
import com.psbc.canteen.common.enumeration.ErrorType;

import java.io.Serializable;

/**
 * <pre>
 * 功   能: 返回结果类，用于得到状态及返回信息，方便前端查看
 * 日   期: 2014-6-24上午9:39:51
 * </pre>
 */
public class AppResultUtil<T> implements Serializable {

	private static final long serialVersionUID = 5984957786423092079L;
	private String msg;
	private T data;
	private int code;
	private String subCode = ErrorType.ErrorTypeEnum.FAILURE.getName();
	private String system_time = DateUtils.getSysStringTime();// 当前系统时间，作用：客户端计算多久前评论的

	public AppResultUtil() {
		initError();
	}

	public AppResultUtil initError() {
		return this.init(1002, "操作失败", null);
	}

	public AppResultUtil initSuccess() {
		return this.initSuccess(null);
	}

	public AppResultUtil initSuccess(T data) {
		return init(0, "操作成功", data);
	}

	public AppResultUtil init(int code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public AppResultUtil setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public T getData() {
		/*if (StringUtils.isBlank(data)) {
			return (T) new Object();
		}*/
		return data;
	}

	public AppResultUtil setData(T data) {
		this.data = data;
		return this;
	}
	public AppResultUtil setCode(int code) {
		this.code = code;
		return this;
	}

	public int getCode() {
		return code;
	}

	public AppResultUtil setCode(ErrorType.ErrorTypeEnum code) {
		this.code = code.getCode();
		this.msg = code.getMessage();
		this.subCode = code.getName();
		return this;
	}

	public String getSystem_time() {
		return system_time;
	}

	public void setSystem_time(String system_time) {
		this.system_time = system_time;
	}

	public String getSubCode() {
		return subCode;
	}

	public AppResultUtil setSubCode(String subCode) {
		this.subCode = subCode;
		return this;
	}
}
