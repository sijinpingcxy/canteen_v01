package com.psbc.canteen.voucher.enums;


import com.psbc.canteen.voucher.entity.ConfigurationEntity;

/**
 *<pre>
 * 功       能: 配置表初始化数据方法配置
 * 涉及版本: V1.0.0 
 * 创  建  者:
 * 日       期: 2015-6-26下午4:58:41
 * Q    Q:
 *</pre>
 */
public interface ConfigurationEnumValue {
	public String getKey();
	public String getValue();
	public ConfigurationEntity getConfiguration();

	public void setKey(String key);
	public void setValue(String value);
	public void setConfiguration(ConfigurationEntity configuration);
}
