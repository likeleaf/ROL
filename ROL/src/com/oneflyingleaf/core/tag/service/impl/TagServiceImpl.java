package com.oneflyingleaf.core.tag.service.impl;

import java.util.List;

import com.oneflyingleaf.core.tag.dao.TagDao;
import com.oneflyingleaf.core.tag.service.TagService;


public class TagServiceImpl implements TagService{

	private TagDao tagDao;
	
	@Override
	public  List list(String hql, Integer pageNow, Integer pageCount) {
		return tagDao.list(hql, pageNow, pageCount);
	}

	@Override
	public <T> List<T> listBySql(String hql, T t) {
		return tagDao.listBySql(hql, t);
	}

	@Override
	public int getCount(String name) {
		return tagDao.getCount(name);
	}

	public TagDao getTagDao() {
		return tagDao;
	}

	public void setTagDao(TagDao tagDao) {
		this.tagDao = tagDao;
	}

}
