package com.oneflyingleaf.core.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oneflyingleaf.core.dao.BaseDao;
import com.oneflyingleaf.core.service.BaseService;

@Service("baseService")
public class BasicService implements BaseService{
	
	@Resource(name="baseDao")
	private BaseDao baseDao;

	@Override
	public <T> List<T> find(String hql, Object[] params) {
		return baseDao.find(hql, params);
	}

	@Override
	public <T> List<T> findBySQL(String sql, Object[] params, Class<?> clazz) {
		return baseDao.findBySQL(sql, params, clazz);
	}

	@Override
	public <T> T findOne(String hql, Object[] params) {
		return baseDao.findOne(hql, params);
	}

	@Override
	public <T> T findOneBySQL(String sql, Object[] params, Class<?> clazz) {
		return baseDao.findOneBySQL(sql, params, clazz);
	}

	@Override
	public <T> T get(Class<?> clazz, Serializable id) {
		return baseDao.get(clazz, id);
	}

	@Override
	public <T> boolean save(T t) {
		return baseDao.save(t);
	}

	@Override
	public <T> boolean saveAll(List<T> lists) {
		return baseDao.saveAll(lists);
	}

	@Override
	public <T> boolean saveOrUpdate(T t) {
		return baseDao.saveOrUpdate(t);
	}

	@Override
	public <T> boolean update(T t) {
		return baseDao.update(t);
	}

	@Override
	public <T> boolean delete(T t) {
		return baseDao.delete(t);
	}

	@Override
	public <T> boolean deleteAll(List<T> lists) {
		return baseDao.deleteAll(lists);
	}

	@Override
	public int exec(String sql, Object[] params) {
		return baseDao.exec(sql, params);
	}

	@Override
	public <T> List<T> padingFind(String hql, Object[] params,
			Integer pageCount, Integer pageNow) {
		return baseDao.padingFind(hql, params, pageCount, pageNow);
	}

	@Override
	public <T> List<T> padingFindBySQL(String sql, Object[] params,
			Integer pageCount, Integer pageNow, Class<?> clazz) {
		return baseDao.padingFindBySQL(sql, params, pageCount, pageNow, clazz);
	}

}
