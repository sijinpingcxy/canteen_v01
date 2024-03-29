package com.psbc.canteen.voucher.entity;

import com.psbc.canteen.common.utils.entity.BaseEntity;
//import org.hibernate.validator.constraints.Length;

/**
 *<pre>
 * 功       能: 字典数据表
 * 涉及版本: V1.0.0 
 * 创  建  者:
 * 日       期: 2017-03-13 13:17:22
 * Q    Q:
 *</pre>
 */
public class ConfigurationEntity extends BaseEntity {

	private static final long serialVersionUID = -2978764484832L;
	
	private Integer versionInt;// 版本号
	//@Length(min=0, max=100, message = "WEBPLATFORM.CONFIGURATION.DICTIONARYKEY")
	private String key;// KEY
	//@Length(min=0, max=16777215, message = "WEBPLATFORM.CONFIGURATION.DICTIONARYVALUE")
	private String value;// value
	//@Length(min=0, max=100, message = "WEBPLATFORM.CONFIGURATION.REMARK")
	private String remark;// 备注说明
	private String dataType;//数据类型
	
	
	/****以下是表中不存在的属性定义*******************************************************************************/
	/****V1.0.0版本*******************************************************************************/
	private String dictionaryKey;// 字典键
	private String dictionaryValue;// 字典值
	
	//无参构造方法
	public ConfigurationEntity() {
		super();
	}
	
	public ConfigurationEntity(Integer versionInt, String key,
                               String value) {
		super();
		this.versionInt = versionInt;
		this.key = key;
		this.value = value;
	}

	public ConfigurationEntity(Integer versionInt) {
		this.setVersionInt(versionInt);
	}
	
	//TID参数构造方法
	public ConfigurationEntity(String uuid) {
		super();
		this.setUuid(uuid);
	}
	
	public Integer getVersionInt() {
		return versionInt;
	}

	public void setVersionInt(Integer versionInt) {
		this.versionInt = versionInt;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDictionaryKey() {
		return dictionaryKey;
	}

	public void setDictionaryKey(String dictionaryKey) {
		this.dictionaryKey = dictionaryKey;
	}

	public String getDictionaryValue() {
		return dictionaryValue;
	}

	public void setDictionaryValue(String dictionaryValue) {
		this.dictionaryValue = dictionaryValue;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
}
