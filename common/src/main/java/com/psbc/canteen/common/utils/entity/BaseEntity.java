package com.psbc.canteen.common.utils.entity;


import com.psbc.canteen.common.utils.string.StringUtils;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * <pre>
 * 功   能: 实体基类
 * 日   期: 2014-6-22下午8:57:51
 * </pre>
 */
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 3864100716825196678L;

	private String uuid;//
	private Timestamp startSearchTime;// 开始时间，供后台使用：主要用于查询某个时间段范围内的数据
	private Timestamp endSearchTime;// 结束时间
	private boolean checked; // 默认选中，用于后台表与表关联时，修改功能默认选中数据
	private Integer delFlag;//数据状态，0：正常，1：已删除

	private Integer pageNo;// 从第几页开始查
	//private Integer pageSize = Integer.valueOf(ConfigurationEnum.PAGE_SIZE.getValue());// 每页显示多少条
	private Integer pageSize;

	private String created;// 创建时间
	private String modified;//
    private String sort_name;//排序字段名称
	private Integer sort_type;//排序类型;   1 , -1 //默认升序


	public Timestamp getStartSearchTime() {
		return startSearchTime;
	}

	public void setStartSearchTime(Timestamp startSearchTime) {
		this.startSearchTime = startSearchTime;
	}

	public Timestamp getEndSearchTime() {
		if (this.endSearchTime != null) {
			return new Timestamp(this.endSearchTime.getTime()
					+ (1 * 24 * 60 * 60 * 1000));// 给结果时间加一天
		}
		return endSearchTime;
	}

	public void setEndSearchTime(Timestamp endSearchTime) {
		this.endSearchTime = endSearchTime;
	}

	public boolean getChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}



	public void setSort_name(String sort_name) {
		this.sort_name = sort_name;
	}

	public Integer getSort_type() {
		return sort_type;
	}

	public void setSort_type(Integer sort_type) {
		if (StringUtils.isBlank(sort_type)) {
			sort_type = 1;
		}
		this.sort_type = sort_type;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}
}
