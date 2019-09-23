package com.psbc.canteen.voucher.api;


import com.psbc.canteen.voucher.entity.ConfigurationEntity;
import com.psbc.canteen.common.utils.api.IBaseService;
import com.psbc.canteen.common.utils.resultUtil.ResultUtil;

import java.util.List;
import java.util.Map;


/**
 *<pre>
 * 功       能: 字典数据表
 * 涉及版本: V1.0.0 
 * 日       期: 2017-03-13 13:17:22
 * Q    Q:
 *</pre>
 */
public interface IConfigurationService extends IBaseService<ConfigurationEntity, String> {

	/**
	 * <pre>
	 * 说       明: 
	 * 涉及版本: V1.0.0  
	 * 创  建  者:
	 * 日       期: 2017年3月13日下午1:25:09
	 * Q    Q:
	 * </pre>
	 */
	public boolean initSysConfiguration(ConfigurationEntity entity) throws Exception;

	/**
	 * <pre>
	 * 说       明: 
	 * 涉及版本: V1.0.0  
	 * 创  建  者:
	 * 日       期: 2017年3月13日下午1:31:35
	 * Q    Q:
	 * </pre>
	 * @return TODO
	 */
	public boolean initData() throws Exception;

	/**
	 * <pre>
	 * 说       明: 
	 * 涉及版本: V2.0.0  
	 * 创  建  者:
	 * 日       期: 2017年5月5日下午2:42:09
	 * Q    Q:
	 * </pre>
	 */
	public ResultUtil insertConfiguration(ConfigurationEntity entity) throws Exception;

	/**
	 * <pre>
	 * 说       明: 
	 * 涉及版本: V2.0.0  
	 * 创  建  者:
	 * 日       期: 2017年6月21日上午9:26:25
	 * Q    Q:
	 * </pre>
	 */
	public Map<String, String> sysParam() throws Exception;

	/**
	 * <pre>
	 * 说       明: 
	 * 涉及版本: V2.0.0  
	 * 创  建  者:
	 * 日       期: 2017年6月23日下午4:01:38
	 * Q    Q:
	 * </pre>
	 */
	public List<ConfigurationEntity> findAll(ConfigurationEntity entity) throws Exception;

	public ResultUtil updateConfiguration(ConfigurationEntity entity) throws Exception;


	public String getTestValue() throws Exception;

}
