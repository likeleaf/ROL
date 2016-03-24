package com.oneflyingleaf.background.core.util;

import org.apache.commons.lang3.StringUtils;

public class DataUtils {
	
	//getPageRange������rowsֵת������ʱʹ��
	private final static int DEFAULT_ROWS = 15;
	//getPageRange������pageֵת������ʱʹ��
	private final static int DEFAULT_PAGE = 1;
	
	/**
	 * ���ݴ����ķ�Χ�õ���Ӧ�ļ�¼�ķ�Χ����Ҫ����easyui��oracle�еķ�ҳ��Χ�Ĳ�ѯ
	 * @param page ��ǰҳ
	 * @param rows ÿҳ�ļ�¼��
	 * @param defaultRows ���ÿҳ�ļ�¼���������ص�ֵ,С��0ʱ������Ĭ�ϵ�DataUtils.DEFAULT_ROWS
	 * @return ���س���Ϊ2�����飬��ʾpage��rows
	 */
	public static int[] getPageAndRows(String page,String rows,int defaultRows){
		if(StringUtils.isBlank(page)) page = String.valueOf(DEFAULT_PAGE);
		if(defaultRows <= 0) defaultRows = DEFAULT_ROWS;
		if(StringUtils.isBlank(rows)) rows = String.valueOf(defaultRows);
		
		int ipage = 0;
		int irows = 0;
		try {
			ipage = Integer.parseInt(page);
		} catch (Exception e) {
			ipage = DEFAULT_PAGE;
		}
		try {
			irows = Integer.parseInt(rows);
		} catch (Exception e) {
			irows = defaultRows;
		}
		
		if(ipage <= 0){
			ipage = DEFAULT_PAGE;
		}
		
		if(irows <= 0){
			irows = DEFAULT_ROWS;
		}
		int[] range = new int[2];
		range[0] = ipage;
		range[1] = irows;
		
		return range;
	}
	
	
	/**
	 * ���ݴ����ķ�Χ�õ���Ӧ�ļ�¼�ķ�Χ����Ҫ����easyui��oracle�еķ�ҳ��Χ�Ĳ�ѯ�����ת����������ʹ��ȱʡֵ
	 * @param page ��ǰҳ
	 * @param rows ÿҳ�ļ�¼��
	 * @return ���س���Ϊ2�����飬��ʾ��Χ[a,b]
	 */
	public static int[] getPageAndRows(String page,String rows){
		return getPageAndRows(page, rows, -1);
	}
}