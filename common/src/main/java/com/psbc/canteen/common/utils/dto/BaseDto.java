package com.psbc.canteen.common.utils.dto;

import java.io.Serializable;

/**
 * <pre>
 * 功   能: Dto基类
 * 日   期: 2014-6-22下午8:57:51
 * </pre>
 */
public class BaseDto implements Serializable {

	private static final long serialVersionUID = -3671852735736781507L;
	private String uuid;
	private String created;// 创建时间

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}
}
