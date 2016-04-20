package com.oneflyingleaf.core.util.helper;

public interface QueryHelper {
	public static final String ORDER_BY_DESC = "DESC";
	public static final String ORDER_BY_ASC = "ASC";
	/**
	 * 添加查询条件
	 * @param condition 查询条件 需要添加 = ，like等查询条件
	 * @param value 值 ,没有值时设置为null
	 */
	void addCondition(String condition,Object value);

	/**
	 * 添加查询条件,并对value的值进行验证。check 为true时，value为null或者为"",则不添加查询条件
	 * @param condition
	 * @param value 
	 * @param check false 不验证，true 验证
	 */
	void addCondition(String condition, Object value,boolean check);
	/**
	 * 添加排序
	 * @param filed
	 * @param seq
	 */
	void addOrderBy(String filed,String seq);
	
	/**
	 * 得到查询语句
	 * @return
	 */
	String getHQL();
	
	/**
	 * 得到查询的条件对应的值
	 * @return
	 */
	Object[] getValue();
	
}
