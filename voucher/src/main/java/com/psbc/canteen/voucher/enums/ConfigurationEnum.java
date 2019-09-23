package com.psbc.canteen.voucher.enums;

import com.psbc.canteen.voucher.entity.ConfigurationEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * <pre>
 * 功       能: 配置表初始化数据功能
 * 涉及版本: V1.0.0 
 * 日       期: 2015-6-26下午5:57:17
 * </pre>
 */
public enum ConfigurationEnum implements ConfigurationEnumValue {



	PAGE_SIZE,//默认分页大小
	;

	private final Logger log = LoggerFactory.getLogger(ConfigurationEnum.class);
	private String key;// KEY
	private String value;// 值
	private ConfigurationEntity configuration;// 对象

	private ConfigurationEnum() {

	}

	private ConfigurationEnum(ConfigurationEntity sysConfiguration, String value) {
		this.configuration = sysConfiguration;
		this.value = value;
	}

	@Override
	public ConfigurationEntity getConfiguration() {// 从REDIS获取最新值
		return this.configuration;
	}

	@Override
	public void setConfiguration(ConfigurationEntity configuration) {
		this.configuration = configuration;
	}

	@Override
	public String getValue() {// 从REDIS获取最新值
		return this.value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String getKey() {
		return this.key;
	}

	@Override
	public void setKey(String key) {
		this.key = key;
	}
}