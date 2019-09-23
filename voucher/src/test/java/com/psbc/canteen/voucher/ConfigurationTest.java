package com.psbc.canteen.voucher;

import com.alibaba.fastjson.JSONObject;
import com.psbc.canteen.voucher.entity.ConfigurationEntity;
import com.psbc.canteen.common.utils.InterfacePage;
import com.psbc.canteen.voucher.api.IConfigurationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *<pre>
 * 涉及版本: V1.0.0
 * 日       期: 2018-08-27 11:32:46
 *</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = VoucherApplication.class)
public class ConfigurationTest {

	@Autowired
	private IConfigurationService configurationService;

	/**
	 *<pre>
	 * 说       明: 预加载
	 * 涉及版本: V1.0.0  
	 * 创  建  者:
	 * 日       期: 2018-08-27 11:32:46
	 *</pre>
	 */
	@Before
	public void before() {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 *<pre>
	 * 说       明: 查询分页数量
	 * 涉及版本: V1.0.0  
	 *</pre>
	 */
	@Test
	public void findPage() {
		try {
			
			ConfigurationEntity entity = new ConfigurationEntity();
			InterfacePage<ConfigurationEntity> InterfacePage = new InterfacePage<ConfigurationEntity>();

			InterfacePage resultUtil= this.configurationService.findPage(entity, InterfacePage);
			System.out.println(JSONObject.toJSONString(resultUtil));
			//PrintWriteUtil.junitPrint(resultUtil, Thread.currentThread().getStackTrace());
			//Assert.assertEquals(resultUtil.getCode(), 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test@Rollback(true)
	public void insert() {
		try {
			ConfigurationEntity entity = new ConfigurationEntity();
			entity.setKey("PAGE_SIZE1");
			entity.setValue("10");
			entity.setVersionInt(1);
			entity.setRemark("3");
			this.configurationService.insert(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
