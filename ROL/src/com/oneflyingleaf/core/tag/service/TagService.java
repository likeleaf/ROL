package com.oneflyingleaf.core.tag.service;

import java.util.List;

public interface TagService {
	//根据相关的hql得到list集合
	List list(String hql,Integer pageNow,Integer pageCount);
	
	//根据相关的sql得到list集合
	<T> List<T> listBySql(String hql,T t);
	
	//根据相关的javaBean得到它的记录总数
	int getCount(String name);
}
