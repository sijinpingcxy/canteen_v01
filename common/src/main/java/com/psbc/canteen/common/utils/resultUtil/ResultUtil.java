package com.psbc.canteen.common.utils.resultUtil;


import com.psbc.canteen.common.utils.InterfacePage;
import com.psbc.canteen.common.enumeration.ErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * <pre>
 * 功   能: 返回结果类，用于得到状态及返回信息，方便前端查看
 * 创建者:
 * 日   期: 2014-6-24上午9:39:51
 * Q  Q:
 * </pre>
 */
public class ResultUtil<T> implements Serializable {
	private final static Logger log = LoggerFactory.getLogger(ResultUtil.class);

	private static final long serialVersionUID = 5984957786423092079L;
	private String msg;
	private T data;
	private int code;
	private String subCode;
	private InterfacePage page = new InterfacePage();// 分页
	private Timestamp systemTime = new Timestamp(System.currentTimeMillis());// 当前系统时间，作用：客户端计算多久前评论的

	public ResultUtil() {
		initError();
	}

	public ResultUtil initError() {
		return this.init(1002, "操作失败", null);
	}

	public ResultUtil initSuccess() {
		return this.initSuccess(null);
	}

	public ResultUtil initSuccess(T data) {
		return init(0, "操作成功", data);
	}

	public ResultUtil init(int code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public ResultUtil setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public T getData() {
		/*if (data == null) {
			return (T) new Object();
		}*/
		return data;
	}

	public ResultUtil setData(T data) {
		this.data = data;
		return this;
	}

	public int getCode() {
		return code;
	}

	public ResultUtil setCode(ErrorType.ErrorTypeEnum code) {
		this.code = Integer.valueOf(code.getCode());
		this.msg = code.getMessage();
		this.subCode = code.getName();
		return this;
	}

	public ResultUtil setCode(Integer code) {
		this.code = code;
		return this;
	}

	public InterfacePage getPage() {
		return page;
	}

	public ResultUtil setPage(InterfacePage page) {
		this.page = page;
		return this;
	}

	public Timestamp getSystemTime() {
		return systemTime;
	}

	public void setSystemTime(Timestamp systemTime) {
		this.systemTime = systemTime;
	}

}
