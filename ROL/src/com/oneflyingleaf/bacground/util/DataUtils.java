package com.oneflyingleaf.bacground.util;

import org.apache.commons.lang3.StringUtils;

public class DataUtils {
	
	//getPageRange方法中rows值转换出错时使用
	private final static int DEFAULT_ROWS = 15;
	//getPageRange方法中page值转换出错时使用
	private final static int DEFAULT_PAGE = 1;
	
	/**
	 * 根据传进的范围得到对应的记录的范围，主要用于easyui在oracle中的分页范围的查询
	 * @param page 当前页
	 * @param rows 每页的记录数
	 * @param defaultRows 如果每页的记录数出错返回的值
	 * @return 返回长度为2的数组，表示范围[a,b]
	 */
	public static int[] getPageRange(String page,String rows,int defaultRows){
		if(StringUtils.isBlank(page)) page = String.valueOf(DEFAULT_PAGE);
		if(defaultRows <= 0) defaultRows = DEFAULT_ROWS;
		if(StringUtils.isBlank(rows)) page = String.valueOf(defaultRows);
		
		int ipage = 0;
		int irows = 0;
		try {
			ipage = Integer.parseInt(page);
		} catch (Exception e) {
			ipage = DEFAULT_PAGE;
		}
		try {
			irows = Integer.parseInt(page);
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
		range[0] = (ipage-1)*irows;
		range[1] = ipage*irows;
		
		return range;
	}
	
	/**
	 * 根据传进的范围得到对应的记录的范围，主要用于easyui在oracle中的分页范围的查询，如果转换出错，则将使用缺省值
	 * @param page 当前页
	 * @param rows 每页的记录数
	 * @return 返回长度为2的数组，表示范围[a,b]
	 */
	public static int[] getPageRange(String page,String rows){
		return getPageRange(page, rows, -1);
	}
}
