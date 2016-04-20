package com.oneflyingleaf.core.tag.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.oneflyingleaf.core.tag.dao.TagDao;
import com.oneflyingleaf.core.tag.service.TagService;


public class TagDaoImpl implements TagDao{
	
	//缺省的每页的数量
	public  static  final int DEFAULT_PAGECOUNT = 10;

	private SessionFactory sf;
	
	Log log = LogFactory.getLog(TagService.class);
	
	@Override
	public <T> List<T> list(String hql,  Integer pageNow, Integer pageCount) {
		log.info(hql);
		Query query = getSession().createQuery(hql);
		if(pageCount != null){
			query.setMaxResults(pageCount);
		}
		if(pageNow != null){
			if(pageCount == null){
				pageCount = DEFAULT_PAGECOUNT;
			}
			query.setFirstResult((pageNow-1)*pageCount);
		}
		return query.list();
	}

	@Override
	public <T> List<T> listBySql(String sql, T t) {
		log.info(sql);
		SQLQuery query = getSession().createSQLQuery(sql);
		if(t != null){
			query.addEntity(t.getClass());
		}
		return query.list();
	}

	@Override
	public int getCount(String name) {
		Query query = getSession().createQuery("select count(*) from " + name);
		return Integer.parseInt(query.list().get(0)+"");
	}
	
	public <T>List<T> query(String hql ,Object[] obj){
		Query query = getSession().createQuery(hql);
		if(obj != null){
			for(Object o :obj){
				query.setParameter(0, o);
			}
		}
		return query.list();
	} 


	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public Session getSession() {
		return sf.getCurrentSession();
	}

}
