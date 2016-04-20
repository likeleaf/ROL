package com.oneflyingleaf.core.tag.dao;

import java.util.List;

public interface TagDao {
	
	public <T> List<T> list(String hql, Integer pageNow, Integer pageCount);

	public <T> List<T> listBySql(String hql, T t);

	public int getCount(String name) ;
	
	public <T >List<T> query(String hql,Object[] obj);
}
