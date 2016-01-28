package com.oneflyingleaf.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.oneflyingleaf.dao.BaseDao;

public class BasicDaoImpl implements BaseDao{
	
	@Resource(name="sessionFactory")
	private SessionFactory sf;

	@SuppressWarnings("unchecked")
	public <T extends Serializable> List<T> find(String hql, List<Object> params) {
		Query query = null;
		try{
			query = getSession().createQuery(hql);
			if(params != null){
				for(int i = 0;i<params.size();i++){
					query.setParameter(i, params.get(i));
				}
			}
			return query.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findBySQL(String sql,
			List<Object> params, Class<?> clazz) {
		SQLQuery SQLquery = null;
		try {
			SQLquery = getSession().createSQLQuery(sql);
			if(params != null){
				for(int i = 0;i<params.size();i++){
					SQLquery.setParameter(i, params.get(i));
				}
			}
			
			if(clazz != null){
				SQLquery.addEntity(clazz);
			}
			return SQLquery.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public <T extends Serializable> T findOne(String hql, List<Object> params) {
		Query query = null;
		try{
			query = getSession().createQuery(hql);
			if(params != null){
				for(int i = 0;i<params.size();i++){
					query.setParameter(i, params.get(i));
				}
			}
			List<T> list = query.list();
			return (T) ((list != null && list.size() >0)?list.get(0):null);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public <T> T findOneBySQL(String sql,
		List<Object> params, Class<?> clazz) {
		SQLQuery SQLquery = null;
		try {
			SQLquery = getSession().createSQLQuery(sql);
			if(params != null){
				for(int i = 0;i<params.size();i++){
					SQLquery.setParameter(i, params.get(i));
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

	public int exec(String sql, List<Object> params) {
		SQLQuery SQLQuery = getSession().createSQLQuery(sql);
		if(params != null){
			for(int i = 0;i<params.size();i++){
				SQLQuery.setParameter(i, params.get(i));
			}
		}
		return SQLQuery.executeUpdate();
	}
	
	private Session getSession(){
		return sf.getCurrentSession();
	}

	public <T> T get(Class<?> clazz, Serializable id) {
		try {
			return (T) getSession().get(clazz, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
