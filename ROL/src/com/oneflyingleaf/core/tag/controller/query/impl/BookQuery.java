package com.oneflyingleaf.core.tag.controller.query.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.oneflyingleaf.core.ho.data.Book;
import com.oneflyingleaf.core.ho.data.BookChaper;
import com.oneflyingleaf.core.tag.bean.BookBean;
import com.oneflyingleaf.core.tag.controller.query.Query;
import com.oneflyingleaf.core.tag.service.TagService;

public class BookQuery extends BasicQuery implements Query{
	private BookBean bookBean;
	
	private Log log = LogFactory.getLog(BookQuery.class);
	
	public BookQuery(String hql,BookBean bookBean,TagService tagService){
		this.hql = hql;
		this.bookBean = bookBean;
		this.tagService = tagService;
	}
	
	
	@Override
	public <T> List<T> getList() {
		List<T> list = null;
		String str = hql;
		List<Object[]> objs = null;
		this.finalHql = str;
		if(bookBean.isHqlLan()){
			
			objs = tagService.list(str,bookBean.getPageNow(),bookBean.getPageCount());
			BookChaper  bc = null;
			Book b = null;
			for (Object[] obj : objs) {
				bc = new BookChaper();
				b = new Book();
				b.setBookId(obj[0]+"");
				b.setBookName(obj[1]+"");
				b.setAuthorId(obj[2]+"");
				b.setBookDes(obj[3]+"");
				b.setBookSize(obj[4]+"");
				b.setBookTextCount(obj[5]+"");
				b.setBookStat(obj[6]+"");
				b.setBookPay(obj[7]+"");
//				b.setBookDate(new Timestamp(obj[8]+""));
			}
			bc = new BookChaper();
			
			
			
		}else{
			try {
				if(bookBean.isCheckClass()){
					list = (List<T>) tagService.listBySql(str,bookBean.getClazz().newInstance());
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
