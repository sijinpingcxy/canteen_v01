package com.psbc.canteen.common.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 *<pre>
 * 功       能: UUID工具
 * 涉及版本: 
 * 创  建  者:
 * 日       期: 2015-9-23下午2:26:55
 * Q    Q:
 *</pre>
 */
@Component
public class UUIDUtil {
	private static String testValue;
	@Value("${test.value}")
	private void setTestValue(String value) {
		UUIDUtil.testValue = value;
	}


	public static String returnTestValue(){
		return testValue;
	}

	/**
	 * <pre>
	 * 说   明: UUID  UUIDUTIL
	 * 创建者:
	 * 日   期: 2014-6-24下午2:59:17
	 * Q  Q:
	 * </pre>
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}
	
	/**
	 *<pre>
	 * 说       明: 截取指定长度的UUID
	 * @param endIndex
	 * @return
	 * 涉及版本: 
	 * 创  建  者:
	 * 日       期: 2015-10-20下午4:03:50
	 *</pre>
	 */
	public static String getUUID(Integer endIndex) {
		if (endIndex == null) {
			return null;
		}
		String uuid = UUID.randomUUID().toString();
		return uuid.substring(0, endIndex);
	}
	
	/**
	 * <pre>
	 * 说       明: 获取基本SIGN的UUID   UUIDUTIL
	 * @return
	 * 涉及版本: V1.0.0 
	 * 创  建  者:
	 * 日       期: 2015-7-9下午1:41:16
	 * </pre>
	 */
	public static String getUUIDSign() {
		String uuid = UUID.randomUUID().toString();
		return uuid.substring(0, 16);// 必须是8的倍数才行
	}


	/**
	 * double精度调整
	 *
	 * @param doubleValue
	 *            需要调整的值123.454
	 * @param format
	 *            目标样式".##"
	 * @return
	 */
	public static String decimalFormatToString(double doubleValue, String format) {
		DecimalFormat myFormatter = new DecimalFormat(format);
		String formatValue = myFormatter.format(doubleValue);
		return formatValue;
	}

	/**
	 * 获取UUID
	 *
	 * @return
	 */
	public static String getUuidByJdk(boolean is32bit) {
		String uuid = UUID.randomUUID().toString();
		if (is32bit) {
			return uuid.toString().replace("-", "");
		}
		return uuid;
	}

	/**
	 * 获取流水号
	 * @author hw851212
	 */
	public static String getTranSq(){
		SecureRandom ng = new SecureRandom();
		String randomStr = String.format("%03d", ng.nextInt(100)); //3位随机数
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
		String datefomat = sdf.format(System.currentTimeMillis()); //17位日期
		return  datefomat + randomStr;
	}

	/**
	 * 获取日期字符串
	 * @author hw851212
	 */
	public static String getDateStr(){
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd");
		String datefomat = sdf.format(System.currentTimeMillis());
		return  datefomat;
	}

	/**
	 * 获取日期字符串
	 * @author hw851212
	 */
	public static String getDateStr2(){
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		String datefomat = sdf.format(System.currentTimeMillis());
		return  datefomat;
	}

	public static void main(String[] args) {

		System.out.println(getUUID());
		System.out.println(getUUID());
		System.out.println(getUUID());
		System.out.println(getUUID());
		System.out.println(getUuidByJdk(true));
	}
	
}
