package com.oneflyingleaf.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间日期工具类
 * @author Administrator
 */
public class DateUtils {

	/**
	 * 将时间转换成字符转
	 * @param date 需要转换的时间
	 * @param format 格式化  如"yyyy-MM-dd"
	 */
	public static String formatDate(Date date,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
}
