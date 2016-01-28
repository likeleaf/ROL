package com.oneflyingleaf.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao {
	//��
	/**
	 * ͨ������������ѯ
	 * @param hql
	 * @param params hql�Ĳ��������û�в���list��ֵΪnull
	 * @return
	 */
	<T extends Serializable> List<T> find(String hql,List<Object> params);
	
	/**
	 * ͨ��������ѯ��ʹ��sql���
	 * @param sql 
	 * @param params sql�Ĳ���
	 * @param clazz sql���ҵĽ��ת��Ϊclazz
	 * @return
	 */
	<T> List<T> findBySQL(String sql,List<Object> params,Class<?> clazz);
	
	/**
	 * ͨ������������ѯ
	 * @param hql
	 * @param params hql�Ĳ��������û�в���list��ֵΪnull
	 * @return
	 */
	<T extends Serializable> T findOne(String hql,List<Object> params);
	
	/**
	 * ͨ������������ѯ
	 * @param sql
	 * @param params hql�Ĳ��������û�в���list��ֵΪnull
	 * @return
	 */
	<T> T findOneBySQL(String sql,List<Object> params,Class<?> clazz);
	
	/**
	 * ͨ�������������ʵ��
	 * @param clazz
	 * @param id
	 * @return
	 */
	<T> T get(Class<?> clazz,Serializable id);
	//��
	/**
	 * ���ӵ���ʵ��
	 * @param t
	 * @return
	 */
	<T> boolean save(T t);
	
	/**
	 * ���Ӷ���ʵ��
	 * @param lists
	 * @return
	 */
	<T> boolean saveAll(List<T> lists);

	/**
	 * ��������������ӣ��������޸�
	 * @param t
	 * @return
	 */
	<T> boolean saveOrUpdate(T t);
	
	//��
	/**
	 * ������ص�ʵ��
	 * @param t
	 * @return
	 */
	<T> boolean update(T t);
	
	//ɾ
	
	/**
	 * ɾ�����ʵ��
	 * @param t
	 * @return
	 */
	<T> boolean delete(T t);
	
	/**
	 * ����ɾ�����ʵ��
	 * @param lists
	 * @return
	 */
	<T> boolean deleteAll(List<T> lists);
	
	//ֱ��sql���ִ��
	/**
	 * ֱ��ͨ��sql���ִ����صĲ���
	 * @param sql
	 * @param params
	 * @return
	 */
	int exec(String sql,List<Object> params);
	
	
}
