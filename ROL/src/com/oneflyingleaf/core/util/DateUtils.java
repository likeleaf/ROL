package com.oneflyingleaf.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ʱ�����ڹ�����
 * @author Administrator
 */
public class DateUtils {

	/**
	 * ��ʱ��ת�����ַ�ת
	 * @param date ��Ҫת����ʱ��
	 * @param format ��ʽ��  ��"yyyy-MM-dd"
	 */
	public static String formatDate(Date date,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
}
