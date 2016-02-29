package com.oneflyingleaf.core.dao;

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
	<T> List<T> find(String hql,Object[] params);
	
	/**
	 * ͨ��������ѯ��ʹ��sql���
	 * @param sql 
	 * @param params sql�Ĳ���
	 * @param clazz sql���ҵĽ��ת��Ϊclazz
	 * @return
	 */
	<T> List<T> findBySQL(String sql,Object[] params,Class<?> clazz);
	
	/**
	 * ��ҳ��ѯ hql
	 * @param hql
	 * @param params
	 * @param pageCount ÿҳ������
	 * @param pageNow ��ǰҳ
	 * @return
	 */
	
	<T> List<T> padingFind(String hql , Object[] params,Integer pageCount,Integer pageNow);
	
	/**
	 * ��ҳ��ѯ hql
	 * @param sql
	 * @param params
	 * @param pageCount ÿҳ������
	 * @param pageNow ��ǰҳ
	 * @param clazz
	 * @return
	 */
	<T> List<T> padingFindBySQL(String sql , Object[] params,Integer pageCount,Integer pageNow ,Class<?> clazz);
	
	/**
	 * ͨ������������ѯ
	 * @param hql
	 * @param params hql�Ĳ��������û�в���list��ֵΪnull
	 * @return
	 */
	<T> T findOne(String hql,Object[] params);
	
	/**
	 * ͨ������������ѯ
	 * @param sql
	 * @param params hql�Ĳ��������û�в���list��ֵΪnull
	 * @return
	 */
	<T> T findOneBySQL(String sql,Object[] params,Class<?> clazz);
	
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
	int exec(String sql,Object[] params);
	
	
}
