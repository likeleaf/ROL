package com.oneflyingleaf.core.util.helper.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.oneflyingleaf.core.util.helper.QueryHelper;

public class QueryHelperImpl implements QueryHelper{
	
	private StringBuilder hql = new StringBuilder();
	private StringBuilder where = new StringBuilder();
	private StringBuilder order = new StringBuilder();
	private List<Object> value = new ArrayList<Object>();
	
	
 	
	public QueryHelperImpl(Class<?> clazz,String s){
		hql.append("from ").append(clazz.getSimpleName()).append(" ").append(s).append(" ");
	}

	@Override
	public void addCondition(String condition, Object value) {
			if(StringUtils.isBlank(condition)) return;
		
			where.append(" and ").append(condition);
			if(value != null && StringUtils.isNotBlank(String.valueOf(value))){
				this.value.add(value);
			}
	}
	
	@Override
	public void addCondition(String condition, Object value,boolean check){
			if(check && StringUtils.isBlank(String.valueOf(value))) return ;
			
			addCondition(condition, value);
	}

	@Override
	public void addOrderBy(String filed, String seq) {
		if(seq == null) seq = "";
		if(StringUtils.isNotBlank(filed)){
			order.append(",").append(filed).append(" ").append(seq);
		}
	}

	@Override
	public String getHQL() {
		String w = "";
		String o = "";
		if(where.length() > 4){
			w = " where " + where.substring(4);
		} 
		if(order.length() > 1){
			o = " order by " + order.substring(1);
		}
		return hql + w + o;
	}

	@Override
	public Object[] getValue() {
		Object [] obj = new Object[value.size()];
		return value.toArray(obj);
	}

}
