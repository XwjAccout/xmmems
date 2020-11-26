package com.xmmems.common.utils;


import com.xmmems.common.exception.XMException;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间转换格式类型，可在原有基础上自行添加
 * @author zwt
 *
 */
public class FormatUtil {

	public final static String SECOND_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
	public final static String SECOND="yyyyMMddHHmmss";

	//获取设定格式时间字符串
	public static String getdateFormat(String format,Date date){
		return new SimpleDateFormat(format).format(date);
	}
	
	//转化指定格式时间串
	public static Date getDate(String format,String date){
		try {
			return new SimpleDateFormat(format).parse(date);
		} catch (ParseException e) {
			throw new XMException(500, e.getMessage());
		}
	}
	
	/**
	 * 除法运算
	 */
	public static Double divided( double dividend, double divisor, int digit ) {
		Double result = 0.0;
		if ( divisor != 0L ) {
			result = dividend / divisor;
		}
		if ( digit < 0 ) {
			digit = 0;
		}
		BigDecimal bd = new BigDecimal(result);
		return bd.setScale(digit, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/**
	 * 获取适当小数位数
	 */
	public static Double scale(Double value,Integer digit){
		if(digit==null){
			digit=4;
		}
		BigDecimal bd = new BigDecimal(value);
		return bd.setScale(digit, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

}
