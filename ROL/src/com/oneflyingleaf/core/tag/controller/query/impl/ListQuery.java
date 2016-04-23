package com.oneflyingleaf.core.tag.controller.query.impl;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.oneflyingleaf.core.tag.bean.AjaxBean;
import com.oneflyingleaf.core.tag.controller.query.Query;
import com.oneflyingleaf.core.tag.service.TagService;
import com.oneflyingleaf.core.util.SpringUtils;

public class ListQuery extends BasicQuery implements Query {

	private AjaxBean jb = null;
	private static Log log = LogFactory.getLog(ListQuery.class);
	
	public ListQuery(String hql ,AjaxBean jb,TagService tagService){
		this.hql = hql;
		this.jb = jb;
		this.tagService = tagService;
	}

	@Override
	public <T> List<T> getList() {
		List<T> list = null;
		String str = hql;
		this.finalHql = str;
		if(jb.isHqlLan()){
			list = tagService.list(str,jb.getPageNow(),jb.getPageCount());
		}else{
			try {
				if(jb.isCheckClass()){
					list = (List<T>) tagService.listBySql(str,jb.getClazz().newInstance());
				}else{
					list = (List<T>) tagService.listBySql(str,null);
				}
					
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		log.info("前台请求:" + str);
		
		return list;
	}
	
	public int getCount(){
		List<Object> obj = tagService.query("select count(*)  "+finalHql, null);
		
		return Integer.parseInt(obj.get(0)+"");
	}
}
