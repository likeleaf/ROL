package com.oneflyingleaf.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao {
	//查
	/**
	 * 通过参数条件查询
	 * @param hql
	 * @param params hql的参数，如果没有参数list的值为null
	 * @return
	 */
	<T extends Serializable> List<T> find(String hql,List<Object> params);
	
	/**
	 * 通过参数查询，使用sql语句
	 * @param sql 
	 * @param params sql的参数
	 * @param clazz sql查找的结果转型为clazz
	 * @return
	 */
	<T> List<T> findBySQL(String sql,List<Object> params,Class<?> clazz);
	
	/**
	 * 通过参数条件查询
	 * @param hql
	 * @param params hql的参数，如果没有参数list的值为null
	 * @return
	 */
	<T extends Serializable> T findOne(String hql,List<Object> params);
	
	/**
	 * 通过参数条件查询
	 * @param sql
	 * @param params hql的参数，如果没有参数list的值为null
	 * @return
	 */
	<T> T findOneBySQL(String sql,List<Object> params,Class<?> clazz);
	
	/**
	 * 通过主键查找相关实体
	 * @param clazz
	 * @param id
	 * @return
	 */
	<T> T get(Class<?> clazz,Serializable id);
	//增
	/**
	 * 增加单项实例
	 * @param t
	 * @return
	 */
	<T> boolean save(T t);
	
	/**
	 * 增加多项实例
	 * @param lists
	 * @return
	 */
	<T> boolean saveAll(List<T> lists);

	/**
	 * 如果不存在则增加，存在则修改
	 * @param t
	 * @return
	 */
	<T> boolean saveOrUpdate(T t);
	
	//改
	/**
	 * 更新相关的实例
	 * @param t
	 * @return
	 */
	<T> boolean update(T t);
	
	//删
	
	/**
	 * 删除相关实例
	 * @param t
	 * @return
	 */
	<T> boolean delete(T t);
	
	/**
	 * 批量删除相关实例
	 * @param lists
	 * @return
	 */
	<T> boolean deleteAll(List<T> lists);
	
	//直接sql语句执行
	/**
	 * 直接通过sql语句执行相关的操作
	 * @param sql
	 * @param params
	 * @return
	 */
	int exec(String sql,List<Object> params);
	
	
}
