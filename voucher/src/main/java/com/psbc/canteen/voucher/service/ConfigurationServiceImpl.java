package com.psbc.canteen.voucher.service;

import com.psbc.canteen.common.enumeration.ErrorType.ErrorTypeEnum;
import com.psbc.canteen.common.utils.InterfacePage;
import com.psbc.canteen.common.utils.UUIDUtil;
import com.psbc.canteen.common.utils.date.DateUtils;
import com.psbc.canteen.common.utils.resultUtil.ResultUtil;
import com.psbc.canteen.common.utils.string.StringUtils;
import com.psbc.canteen.voucher.api.IConfigurationService;
import com.psbc.canteen.voucher.entity.ConfigurationEntity;
import com.psbc.canteen.voucher.enums.ConfigurationEnum;
import com.psbc.canteen.voucher.enums.ConfigurationEnumValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 功       能: 字典数据表
 * 涉及版本: V1.0.0  
 * 日       期: 2017-03-13 13:17:22
 * </pre>
 */
@Service("configurationService")
public class ConfigurationServiceImpl extends BaseMapperImpl implements IConfigurationService {
	private final static Logger log = LoggerFactory.getLogger(ConfigurationServiceImpl.class);



	/**
	 * <pre>
	 * 说       明: 
	 * 涉及版本: V2.0.0  
	 * 创  建  者:
	 * 日       期: 2017年5月5日下午2:42:01
	 * Q    Q:
	 * </pre>
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public ResultUtil insertConfiguration(ConfigurationEntity entity)
			throws Exception {
		//TODO: 平台参数配置：新增
		ResultUtil resultUtil = new ResultUtil();
		if (StringUtils.isBlank(entity)
				|| StringUtils.isBlankOr(entity.getVersionInt(),
						entity.getDictionaryKey(), entity.getDictionaryValue(), entity.getRemark())) {
			return resultUtil.setCode(ErrorTypeEnum.FAILURE_BASE_LACK_PARAMS)
					.setData("dictionaryKey,dictionaryValue,remark");
		}

		//前端用dictionaryKey, dictionaryValue, 数据库用key, value
		entity.setKey(entity.getDictionaryKey());
		entity.setValue(entity.getDictionaryValue());

		if (!StringUtils.isBlank(this.findOne(new ConfigurationEntity(entity
				.getVersionInt(), entity.getKey(), null)))) {
			return resultUtil.setCode(ErrorTypeEnum.FAILURE_BASE_EXISTS);// 数据已存在
		}
		entity.setUuid(UUIDUtil.getUuidByJdk(true));
		if (this.configurationEntityMapper.insert(entity) > 0) {
			return resultUtil.setCode(ErrorTypeEnum.SUCCESS);
		}
		return resultUtil.setCode(ErrorTypeEnum.FAILURE_BASE_INSERT);
	}

	/**
	 * <pre>
	 * 说      明:  添加数据
	 * @param entity
	 * @return
	 * @throws Exception
	 * 涉及版本: V1.0.0  
	 * 创  建  者:
	 * 日       期: 2017-03-13 13:17:22
	 * </pre>
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public String insert(ConfigurationEntity entity) throws Exception {
		String uuid = UUIDUtil.getUuidByJdk(true);
		entity.setUuid(uuid);
		entity.setCreated(DateUtils.getSysStringTime());
		if (this.configurationEntityMapper.insert(entity) < 1) {
			return null;
		}
		return uuid;
	}

	/**
	 * <pre>
	 * 说      明:  修改数据
	 * @param entity
	 * @return
	 * @throws Exception
	 * 涉及版本: V1.0.0  
	 * 创  建  者:
	 * 日       期: 2017-03-13 13:17:22
	 * </pre>
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer update(ConfigurationEntity entity) throws Exception {
		if (StringUtils.isBlank(entity.getUuid())
				|| StringUtils.isBlankOr(entity.getUuid())) {

			return null;
		}

		return this.configurationEntityMapper.updateById(entity);
	}

	/**
	 *<pre>
	 * 功    能: 修改（进一步封装，向前端返回ResultUtil）
	 * 涉及版本:
	 * 创 建 者: guyuegan
	 * 日    期: 2017年12月04日 下午 14:13:06
	 * Q     Q: 1784286916
	 *</pre>
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResultUtil updateConfiguration(ConfigurationEntity entity) throws Exception {
		ResultUtil resultUtil = new ResultUtil();

		if (StringUtils.isBlank(entity.getUuid())
				|| StringUtils.isBlankOr(entity.getUuid())) {

			return resultUtil.setCode(ErrorTypeEnum.FAILURE_BASE_LACK_PARAMS)
					         .setData("tid");
		}

		if (this.configurationEntityMapper.updateById(entity) == 1){
			return resultUtil.setCode(ErrorTypeEnum.SUCCESS);
		}

		return resultUtil.setCode(ErrorTypeEnum.FAILURE_BASE_UPDATE);
	}

	@Override
	public String getTestValue() throws Exception {
		return UUIDUtil.returnTestValue();
	}

	/**
	 * <pre>
	 * 说       明: 分页查询
	 * @param entity
	 * @return
	 * @throws Exception
	 * 涉及版本: V1.0.0  
	 * 创  建  者:
	 * 日       期: 2017-03-13 13:17:22
	 * </pre>
	 */
	@Override
	public InterfacePage findPage(
			ConfigurationEntity entity, InterfacePage<ConfigurationEntity> page)
			throws Exception {
		/*ResultUtil<List<ConfigurationDto>> resultUtil = new ResultUtil<List<ConfigurationDto>>();
		// 判断分页参数
		ResultUtil pageResult = InterfacePage.validatePage(page);
		if (pageResult != null) {
			return pageResult;
		}
		// 获取总数量
		page.setTotalCount(this.configurationEntityMapper.getCount(entity));
		// 获取分页后的数据
		PageHelper.startPage(page.getPageNo(), page.getPageSize());
		page.setList(this.configurationEntityMapper.findAll(entity));
		List<ConfigurationDto> listDto = new ArrayList<ConfigurationDto>();
		ConfigurationDto dto = null;
		for (ConfigurationEntity ce : page.getList()) {

			dto = new ConfigurationDto(ce);
			listDto.add(dto); // 封装成DTO数据
		}
		return resultUtil.setData(listDto).setPage(page)
				.setCode(ErrorTypeEnum.SUCCESS);*/
		return null;
	}

	/**
	 * <pre>
	 * 说       明: 查询某一条数据
	 * @param entity
	 * @return
	 * @throws Exception
	 * 涉及版本: 
	 * 创  建  者:
	 * 日       期: 2017-03-13 13:17:22
	 * </pre>
	 */
	@Override
	public ConfigurationEntity findOne(ConfigurationEntity entity)
			throws Exception {

		List<ConfigurationEntity> list = this.configurationEntityMapper
				.findAll(entity);
		if (StringUtils.isBlankOr(list) || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	/**
	 * <pre>
	 * 说       明: 根据ID查询数据
	 * @param tid
	 * @return
	 * @throws Exception
	 * 涉及版本: 
	 * 创  建  者:
	 * 日       期: 2017-03-13 13:17:22
	 * </pre>
	 */
	@Override
	public ConfigurationEntity findById(String tid) throws Exception {

		if (StringUtils.isBlank(tid)) {
			return null;
		}
		List<ConfigurationEntity> list = this.configurationEntityMapper
				.findAll(new ConfigurationEntity(tid));
		if (StringUtils.isBlankOr(list) || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	
	/**
	 * <pre>
	 * 说       明: 查询某一条数据
	 * @param entity
	 * @return
	 * @throws Exception
	 * 涉及版本: 
	 * 创  建  者:
	 * 日       期: 2017-03-13 13:17:22
	 * </pre>
	 */
	@Override
	public List<ConfigurationEntity> findAll(ConfigurationEntity entity)
			throws Exception {

		return this.configurationEntityMapper.findAll(entity);
	}

	/**
	 * <pre>
	 * 说       明: 
	 * 涉及版本: V1.0.0 
	 * 创  建  者:
	 * 日       期: 2017年3月13日下午1:25:52
	 * Q    Q:
	 * </pre>
	 */
	@Override
	public boolean initSysConfiguration(ConfigurationEntity entity)
			throws Exception {

		/*if (StringUtils.isBlankOr(entity, entity.getVersionInt())) {

			return false;
		}*/
		List<ConfigurationEntity> list = this.configurationEntityMapper.findAll(entity);
		log.info("配置表配置了"+list.size()+"个参数");
		if (list.isEmpty()) {
			return false;
		}
		Field[] allField = ConfigurationEnum.class.getFields();
		Map<String, Field> fieldMap = new HashMap<String, Field>();
		for (Field field : allField) {
			fieldMap.put(field.getName(), field);
		}
		Class<?> cls = ConfigurationEnum.class;
		String dictionaryKey = "";
		Map<String, ConfigurationEntity> map = new HashMap<String, ConfigurationEntity>();
		for (ConfigurationEntity configuration : list) {

			dictionaryKey = configuration.getKey().trim().toUpperCase();
			if (fieldMap.containsKey(dictionaryKey)) {

				ConfigurationEnumValue e = (ConfigurationEnumValue) Enum
						.valueOf((Class<? extends Enum>) cls,
								configuration.getKey().trim()
										.toUpperCase());

				e.setKey(configuration.getKey());
				e.setValue(configuration.getValue());
				e.setConfiguration(configuration);

				map.put(configuration.getKey(), configuration);
			}
		}
		return true;
	}

	/**
	 * <pre>
	 * 说       明: 初始化基础数据
	 * 涉及版本: V2.0.0 
	 * 创  建  者:
	 * 日       期: 2017年6月21日上午9:22:59
	 * Q    Q:
	 * </pre>
	 */
	@Override
	public boolean initData() throws Exception {

		return this.initSysConfiguration(null);// 初始化当前版本配置信息
		//return true;// 初始化Redis
	}

	/**
	 * <pre>
	 * 说       明: 
	 * 涉及版本: V2.0.0 
	 * 创  建  者:
	 * 日       期: 2017年6月21日上午9:26:34
	 * Q    Q:
	 * </pre>
	 */
	@Override
	public Map<String, String> sysParam() throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		
		return map;
	}
}
