package com.psbc.canteen.voucher.controller;

import com.psbc.canteen.voucher.entity.ConfigurationEntity;
import com.psbc.canteen.common.utils.InterfacePage;
import com.psbc.canteen.common.utils.controller.BaseController;
import com.psbc.canteen.common.utils.resultUtil.ResultUtil;
import com.psbc.canteen.common.utils.string.StringUtils;
import com.psbc.canteen.voucher.api.IConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller
 *
 * @author zhangdd
 * @ClassName: StaffController
 * @create 2019/8/20 11:20
 * @since 1.0.0
 */
@RestController
@RequestMapping("configuration")
public class ConfigurationController extends BaseController {

    @Autowired
    private IConfigurationService configurationService;


    @RequestMapping("findPage")
    @ResponseBody
    public ResultUtil findPageV100(HttpServletRequest request, HttpServletResponse response, ConfigurationEntity entity,
                                   InterfacePage page) throws Exception {
        return renderPageOK(this.configurationService.findPage(entity, page));
    }



    @RequestMapping("testYml")
    @ResponseBody
    public ResultUtil testYml(ConfigurationEntity entity) throws Exception {
        String testValue = this.configurationService.getTestValue();
        if (StringUtils.isNotBlank(testValue)) {
            return renderDataOK(testValue);
        } else {
            return renderFail();
        }

    }


}