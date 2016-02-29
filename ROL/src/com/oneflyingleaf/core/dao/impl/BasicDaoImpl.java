package com.oneflyingleaf.core.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.oneflyingleaf.core.dao.BaseDao;

@Component("baseDao")
public class BasicDaoImpl implements BaseDao{
	
	@Resource(name="sessionFactory")
	private SessionFactory sf;

	public <T> List<T> find(String hql, Object[] params) {
		
		return padingFind(hql, params, null,null);
	}

	public <T> List<T> findBySQL(String sql,
			Object[] params, Class<?> clazz) {
		return padingFindBySQL(sql, params, null, null, clazz);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> padingFind(String hql, Object[] params,
			Integer pageCount, Integer pageNow) {
		
		Query query = null;
		try{
			query = getSession().createQuery(hql);
			if(params != null){
				for(int i = 0;i<params.length;i++){
					query.setParameter(i, params[i]);
				}
			}
			
			/*if(pageCount != null && pageNow != null){
				query.setMaxResults(pageCount);
				query.setFirstResult((pageNow-1) * pageCount);
			}*/
			return query.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ArrayList<T>();
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> List<T> padingFindBySQL(String sql, Object[] params,
			Integer pageCount, Integer pageNow, Class<?> clazz) {
		SQLQuery SQLquery = null;
		try {
			SQLquery = getSession().createSQLQuery(sql);
			if(params != null){
				for(int i = 0;i<params.length;i++){
					SQLquery.setParameter(i, params[i]);
				}
			}
			
			if(clazz != null){
				SQLquery.addEntity(clazz);
			}
			
			if(pageCount != null && pageNow != null){
				SQLquery.setMaxResults(pageCount);
				SQLquery.setFirstResult((pageNow-1) * pageCount);
			}
			return SQLquery.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ArrayList<T>();
	}

	@SuppressWarnings("unchecked")
	public <T> T findOne(String hql, Object[] params) {
		Query query = null;
		try{
			query = getSession().createQuery(hql);
			if(params != null){
				for(int i = 0;i<params.length;i++){
					query.setParameter(i, params[i]);
				}
			}
			List<T> list = query.list();
			return (T) ((list != null && list.size() >0)?list.get(0):null);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public <T> T findOneBySQL(String sql,
		Object[] params, Class<?> clazz) {
		SQLQuery SQLquery = null;
		try {
			SQLquery = getSession().createSQLQuery(sql);
			if(params != null){
				for(int i = 0;i<params.length;i++){
					SQLquery.setParameter(i, params[i]);
				}
			}
			
			if(clazz != null){
				SQLquery.addEntity(clazz);
			}
			List<T> list = SQLquery.list();
			return (T) ((list != null && list.size()>0)?list.get(0):null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public <T> boolean save(T t) {
		try {
			return getSession().save(t) != null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public <T> boolean saveAll(List<T> lists) {
		Session session = getSession();
		Transaction ts = session.getTransaction();
		try {
			ts.begin();
			for (T t : lists) {
				session.save(t);
			}
			
			session.flush();
			session.clear();
			
			ts.commit();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		}
		return false;
	}

	public <T> boolean saveOrUpdate(T t) {
		try {
			getSession().saveOrUpdate(t);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public <T> boolean update(T t) {
		try {
			getSession().update(t);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public <T> boolean delete(T t) {
		try {
			getSession().delete(t);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public <T> boolean deleteAll(List<T> lists) {
		Session session= getSession();
		Transaction ts = null;
		try {
			ts = session.getTransaction();
			ts.begin();
			for (T t : lists) {
				session.delete(t);
			}
			session.flush();
			session.clear();
			
			ts.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		}
		return false;
	}

	public int exec(String sql, Object[] params) {
		SQLQuery SQLQuery = getSession().createSQLQuery(sql);
		if(params != null){
			for(int i = 0;i<params.length;i++){
				SQLQuery.setParameter(i, params[i]);
			}
		}
		return SQLQuery.executeUpdate();
	}
	
	private Session getSession(){
		return sf.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public <T> T get(Class<?> clazz, Serializable id) {
		try {
			return (T) getSession().get(clazz, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
