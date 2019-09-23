package com.psbc.canteen.common.constant;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *<pre>
 * 功   能:   
 * 日   期: 2014-6-23上午11:22:59
 *</pre>
 */
public class Constants {

    /**
     * 错误代码
     */
    private static Properties properties;
    private static Properties propertiesMethod;
    public static String methodParams;	//方法参数加密

	public static final String SIGN = "sign";
	public static final String CHAR_ACTION = ".action";
	public static final String CURRENTUSER = "currentUser";
	public static final String CURRENTUSER_NAME = "currentUserName";
	public static final String ENCODING_UTF8 = "UTF-8";
	public static final String MODULE_LOGIN = "login";
    public static Map<String, String> allSimplePasswordMap = new HashMap<String, String>();//保存了所有简单密码
	public static final String AES_KEY = "";
	public static final String LOG_MODEL = "production";
    
	public static Integer CODE_BASS_INDEX = 0;					//基础
	public static String MSG_NAME = "MsgName";
	public static String APP_INSTANCE_URI = "/page/app/ambient";	//应用实例URI
	public static String APP_INSTANCE_ROLE_NAME = "应用实例角色";

}
