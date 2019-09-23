package com.psbc.canteen.common.enumeration;



import com.psbc.canteen.common.utils.string.StringUtils;

import java.io.*;
import java.util.Properties;


public class ErrorType implements Serializable {
	
	private static final long serialVersionUID = 8339756426615891172L;
	
	private static Properties properties;
	private static Properties propertiesZH;
    private static Properties propertiesMethod;
    
	public static Integer CODE_SYS_INDEX = 0;
	public static Integer CODE_USERS_INDEX = 0;
	public static Integer CODE_APP_INDEX = 0;
	
	static{
        InputStream fis = null;
        InputStream fisMethod = null;
        try {
        	String packageName = StringUtils.getPackageName(ErrorType.class, "/",5);
        	properties = new Properties();
            fis = ErrorType.class.getClassLoader().getResourceAsStream("msg/errorTypeMsg.properties");
    		//fis = new FileInputStream(new File(System.getProperty("user.dir")+"/src/main/resources/properties/msg/errorTypeMsg.properties"));
            properties.load(fis);
            
            propertiesMethod = new Properties();
            fisMethod = ErrorType.class.getClassLoader().getResourceAsStream("sign/sign.properties");
			//fisMethod = new FileInputStream(new File(System.getProperty("user.dir")+"/src/main/resources/properties/sign/sign.properties"));
            propertiesMethod.load(fisMethod);
            
            propertiesZH = new Properties();
    		fis = ErrorType.class.getClassLoader().getResourceAsStream("i18N/lang-zh_CN.properties");
			//fis = new FileInputStream(new File(System.getProperty("user.dir")+"/src/main/resources/properties/i18N/lang-zh_CN.properties"));
    		propertiesZH.load(fis);
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
               if (fis != null) {
            	   fis.close();
               }
               if (fisMethod != null) {
            	   fisMethod.close();
               }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

	

	public static final class Index implements Serializable {
    	
		public static Integer CODE_BASS_INDEX = 0;					//基础
	 	public static Integer CODE_UCENTER_INDEX = 0;				//用户模块
	 	public static Integer CODE_COMMON_INDEX = 0;				//升级模块

        
    }
	public static final class Module implements Serializable {
		public static final String BASE = "5";						//基础模块
		public static final String UCENTER = "21";					//用户模块
		public static final String COMMON = "22";					//升级模块

	}
	
	public enum ErrorTypeEnum implements Serializable {

		/**
		 * 系统错误
		 */
		SUCCESS("2", 0, "SUCCESS"), // 操作成功
		FAILURE("5", 0, "FAILURE"), // 操作失败
        /**
         * BASE
         */
		FAILURE_BASE_TOKEN_PARAMS(Module.BASE,++ Index.CODE_BASS_INDEX,"FAILURE_BASE_TOKEN_PARAMS"), //没获取到TOKEN参数
        FAILURE_BASE_LACK_PARAMS(Module.BASE,++ Index.CODE_BASS_INDEX,"FAILURE_BASE_LACK_PARAMS"), //缺少参数
        FAILURE_BASE_NO_FUNCTION(Module.BASE,++ Index.CODE_BASS_INDEX,"FAILURE_BASE_NO_FUNCTION"), //此用户没有访问此资源的权限
        FAILURE_BASE_ILLEGAL_PARAMS(Module.BASE,++ Index.CODE_BASS_INDEX,"FAILURE_BASE_ILLEGAL_PARAMS"), //参数值不合法
        FAILURE_BASE_SHIRO_TOKEN(Module.BASE,++ Index.CODE_BASS_INDEX,"FAILURE_BASE_SHIRO_TOKEN"), //权限中验证TOKEN失败
        FAILURE_BASE_PARAMS_MD5_ERROR(Module.BASE,++ Index.CODE_BASS_INDEX,"FAILURE_BASE_PARAMS_MD5_ERROR"), //参数加密不正确
        FAILURE_BASE_GET_REDIS(Module.BASE,++ Index.CODE_BASS_INDEX,"FAILURE_BASE_GET_REDIS"), //太久没有操作了，为了安全，需要重新登录哦
        FAILURE_BASE_SELECT(Module.BASE,++ Index.CODE_BASS_INDEX,"FAILURE_BASE_SELECT"), //查询失败
        FAILURE_BASE_INSERT(Module.BASE,++ Index.CODE_BASS_INDEX,"FAILURE_BASE_INSERT"), //添加失败
        FAILURE_BASE_DEL(Module.BASE,++ Index.CODE_BASS_INDEX,"FAILURE_BASE_DEL"), //删除失败
        FAILURE_BASE_UPDATE(Module.BASE,++ Index.CODE_BASS_INDEX,"FAILURE_BASE_UPDATE"), //更新失败
        FAILURE_BASE_AUTH_CODE_PAST_TIME(Module.BASE,++ Index.CODE_BASS_INDEX,"FAILURE_BASE_AUTH_CODE_PAST_TIME"), //验证码已过期，请重新发送
        FAILURE_BASE_AUTH_CODE_FAILURE(Module.BASE,++ Index.CODE_BASS_INDEX,"FAILURE_BASE_AUTH_CODE_FAILURE"), //验证码错误，请重新输入
        FAILURE_BASE_NO_FUNCTIONS(Module.BASE,++ Index.CODE_BASS_INDEX,"FAILURE_BASE_NO_FUNCTIONS"), //没有操作权限
        FAILURE_BASE_GET_REDIS_USERS(Module.BASE,++ Index.CODE_BASS_INDEX,"FAILURE_BASE_GET_REDIS_USERS"), //在REDIS中没有获取到用户数据
        FAILURE_BASE_NO_FIND_DATA(Module.BASE,++ Index.CODE_BASS_INDEX,"FAILURE_BASE_NO_FIND_DATA"), //没找到相符的数据
        FAILURE_BASE_ILLEGALITY_OPERATION(Module.BASE,++ Index.CODE_BASS_INDEX,"FAILURE_BASE_ILLEGALITY_OPERATION"), //非法操作
        FAILURE_BASE_HEADER_LACK_PARAMS(Module.BASE,++ Index.CODE_BASS_INDEX,"FAILURE_BASE_HEADER_LACK_PARAMS"), //Header中缺少参数
        FAILURE_BASE_EXISTS(Module.BASE,++ Index.CODE_BASS_INDEX,"FAILURE_BASE_EXISTS"), //数据已存在
		FAILURE_BASE_REQUIRED_ISNULL(Module.BASE,++ Index.CODE_BASS_INDEX,"FAILURE_BASE_REQUIRED_ISNULL"), //必填项不能为空
		FAILURE_BASE_REQUEST_DATACENTER(Module.BASE,++ Index.CODE_BASS_INDEX,"FAILURE_BASE_REQUEST_DATACENTER"), //请求数据中心服务失败
		FAILURE_BASE_TIME_INTERVAL_MUST_GREATER_ONE(Module.BASE,++ Index.CODE_BASS_INDEX,"FAILURE_BASE_TIME_INTERVAL_MUST_GREATER_ONE"), //开始时间结束时间时间间隔至少一个小时
		FAILURE_BASE_TIME_INTERVAL_MUST_LESS_ONE_DAY(Module.BASE,++ Index.CODE_BASS_INDEX,"FAILURE_BASE_TIME_INTERVAL_MUST_LESS_ONE_DAY"), //开始时间结束时间时间间隔不能超过24小时

		/**
		 * COMMON
		 */
		FAILURE_COMMON_FREQUENT_OPERATION(Module.COMMON, ++Index.CODE_COMMON_INDEX, "FAILURE_COMMON_FREQUENT_OPERATION"),//你操作过于频繁，请稍后重试
		
		/**
		 * USER
		 */
		FAILURE_USERS_CARDNO_ALREADY_EXISTS(Module.UCENTER, ++Index.CODE_UCENTER_INDEX, "FAILURE_USERS_CARDNO_ALREADY_EXISTS"), //此身份证号已经存在
		FAILURE_LOGINNAME_OR_PASSWORD_ERROR(Module.UCENTER, ++Index.CODE_UCENTER_INDEX, "FAILURE_LOGINNAME_OR_PASSWORD_ERROR"),//用户名或密码错误
		FAILURE_USERS_INPUT_PHONE(Module.UCENTER, ++Index.CODE_UCENTER_INDEX, "FAILURE_USERS_INPUT_PHONE"), //请输入正确的手机号
		FAILURE_USERS_REGIST_USER_EXISTS(Module.UCENTER, ++Index.CODE_UCENTER_INDEX,"FAILURE_USERS_REGIST_USER_EXISTS"), //用户名已存在
        FAILURE_USERS_DIFFERENT_PWD(Module.UCENTER, ++Index.CODE_UCENTER_INDEX,"FAILURE_USERS_DIFFERENT_PWD"), //两次输入的密码不一致
        FAILURE_USERS_REGIST_USER(Module.UCENTER, ++Index.CODE_UCENTER_INDEX,"FAILURE_USERS_REGIST_USER"), //注册失败
        FAILURE_USERS_INPUT_USER_NAME(Module.UCENTER, ++Index.CODE_UCENTER_INDEX,"FAILURE_USERS_INPUT_USER_NAME"), //请输入正确的登录名
        FAILURE_USERS_DISABLE(Module.UCENTER, ++Index.CODE_UCENTER_INDEX,"FAILURE_USERS_DISABLE"), //用户已禁用
        FAILURE_USERS_PASSWORD_ERROR(Module.UCENTER, ++Index.CODE_UCENTER_INDEX,"FAILURE_USERS_PASSWORD_ERROR"), //密码输入错误
        FAILURE_USERS_NOT_FOUND(Module.UCENTER, ++Index.CODE_UCENTER_INDEX,"FAILURE_USERS_NOT_FOUND"), //此用户不存在
        FAILURE_USERS_OLD_PWD(Module.UCENTER, ++Index.CODE_UCENTER_INDEX,"FAILURE_USERS_OLD_PWD"), //登录密码错误，请重新输入。如果你忘记了密码，请先到登录页面找回密码后再试。
        FAILURE_USERS_VALIDATE_CARD_NO(Module.UCENTER, ++Index.CODE_UCENTER_INDEX, "FAILURE_USERS_VALIDATE_CARD_NO"), //此身份证不合法
        FAILURE_USERS_INPUT_BUSI_CODE(Module.UCENTER, ++Index.CODE_UCENTER_INDEX, "FAILURE_USERS_INPUT_BUSI_CODE"), //请输入国际编码
        FAILURE_USERS_NOT_PASS(Module.UCENTER, ++Index.CODE_UCENTER_INDEX, "FAILURE_USERS_NOT_PASS"), //您当前未认证，认证通过后才能操作
        FAILURE_USERS_SEND_SMS(Module.UCENTER, ++Index.CODE_UCENTER_INDEX, "FAILURE_USERS_SEND_SMS"), //发送短信失败
        FAILURE_USERS_LOGIN_ERROR(Module.UCENTER,++ Index.CODE_UCENTER_INDEX,"FAILURE_USERS_LOGIN_ERROR"),//登录名或密码错误
        FAILURE_USERS_SERVICE_APPLY_APPLYING(Module.UCENTER,++ Index.CODE_UCENTER_INDEX,"FAILURE_USERS_SERVICE_APPLY_APPLYING"),//您已申请，请耐心等待审核
        FAILURE_USERS_SERVICE_APPLY_PASS(Module.UCENTER,++ Index.CODE_UCENTER_INDEX,"FAILURE_USERS_SERVICE_APPLY_PASS"),//您已在列表中，不需再重新申请
        FAILURE_USERS_PHONE_EXISTS(Module.UCENTER,++ Index.CODE_UCENTER_INDEX,"FAILURE_USERS_PHONE_EXISTS"),//此手机号已经存在
        FAILURE_USERS_USER_ACCOUNT_EXISTS(Module.UCENTER, ++Index.CODE_UCENTER_INDEX,"FAILURE_USERS_USER_ACCOUNT_EXISTS"), //账号已存在
        //您的账号于17:30分在其他设备登录。如非本人操作，则密码可能已经泄露，建议立即修改密码。
        FAILURE_USERS_ERROR_PHONE(Module.UCENTER, ++Index.CODE_UCENTER_INDEX,"FAILURE_USERS_ERROR_PHONE"),//手机号格式有误 
        FAILURE_USERS_AUTH_SEND_MSG_NO(Module.UCENTER,++ Index.CODE_UCENTER_INDEX,"FAILURE_USERS_AUTH_SEND_MSG_NO"),//您需要认证通过后，才可以发送消息
        FAILURE_USERS_USER_STATE_DISBLAED(Module.UCENTER, ++Index.CODE_UCENTER_INDEX,"FAILURE_USERS_USER_STATE_DISBLAED"), //此用户已被禁用
       

        ;
		private String model;
        private int code;
        private String name;
        
        ErrorTypeEnum(String model, int code, String name) {
            this.model = model;
            this.code = code;
            this.name = name;
        }

        public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getCode() {
            return Integer.valueOf(String.format("%s%02d", model, code));
        }

        public String getMessage() {
            return properties.getProperty(name);
        }

        public String getMessage(String defaultKey) {
            return properties.getProperty(name,defaultKey);
        }
        
        public static String getMethodParams(String key) {
    		return propertiesMethod.getProperty(key);
    	}
        
        public static String getZH(String key) {
    		return propertiesZH.getProperty(key);
    	}
	}
}
