package com.oneflyingleaf.core.tag.service;

import java.util.List;

public interface TagService {
	//������ص�hql�õ�list����
	List list(String hql,Integer pageNow,Integer pageCount);
	
	//������ص�sql�õ�list����
	<T> List<T> listBySql(String hql,T t);
	
	//������ص�javaBean�õ����ļ�¼����
	int getCount(String name);
}
