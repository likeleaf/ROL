package com.oneflyingleaf.core.tag.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.oneflyingleaf.core.tag.bean.AjaxBean;
import com.oneflyingleaf.core.tag.controller.query.impl.ListQuery;
import com.oneflyingleaf.core.tag.service.TagService;
import com.oneflyingleaf.core.tag.utils.ClassUtils;
import com.oneflyingleaf.core.util.SpringUtils;

public class ListDeal {
	
	Log log = LogFactory.getLog(ListDeal.class);
	private AjaxBean jb;
	
	private TagService tagService ;
	
	private String finalHql ;
	
	private ListQuery lq ;
	
	
	public ListDeal(AjaxBean jb){
		this.jb = jb;
		try {
			if(jb.isCheckClass()){
				this.jb.setClazz(ClassUtils.getClass(jb.getName(),jb.getPackageName()));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 得到相应的list
	 */
	public <T> List<T> getList(){
		lq = new ListQuery(getQueryString(),jb,SpringUtils.getBean("tagService"));
		return lq.getList();
 	}
	
	
	public int getCount(){
		return lq.getCount();
	}
	

	
	/**
	 * 三种返回值
	 * @return null 表示出错， 如果isHql为true，则返回一个hql语句，如果isHql为false，则表示返回sql语句，isHql默认为true;
	 */
	
	private String getQueryString(){
		if(StringUtils.isNotBlank(jb.getType())){
			if("hql".equals(jb.getType())){
				return jb.getHql().replaceAll("#", "%");
			}else if("sql".equals(jb.getType())){
				jb.setHqlLan(false) ;
				return jb.getSql();
			}
			return null;
		}else{//没有hql和sql语句，直接通过相关的属性传入的值进行拼凑得到hql语句
			StringBuffer sb = new StringBuffer();
			sb.append("from "+ jb.getName() + " ");
			
			//拼合where语句
			if(StringUtils.isNotBlank(jb.getLimit()) || StringUtils.isNotBlank(jb.getLikeLimit()) || StringUtils.isNotBlank(jb.getOtherCon())){
				sb.append("where ");
				//拼合精确查询语句
				if(jb.isLimitCheck() && StringUtils.isNotBlank(getLimit())){
					sb.append(" "+getLimit()+" and ");
				}else if(StringUtils.isNotBlank(jb.getLimit())){
					sb.append(" "+jb.getLimit()+" and ");
				}
				
				//直接将相应的数据放入where中
				if(StringUtils.isNotBlank(jb.getOtherCon())){
					sb.append(" "+jb.getOtherCon() +" and ");
				}
				//拼合模糊查询语句
				if(StringUtils.isNotBlank(getLikeLimit())){
					sb.append(" "+getLikeLimit()+" and ");
				}
				//将最终的where子句传入sb中
				sb = new StringBuffer(sb.substring(0, sb.length()-4));
			}
			
			//拼合order by子句
			if(StringUtils.isNotBlank(jb.getOrder())){
				sb.append(" order by " + jb.getOrder());
			}
			
			return sb.toString();
		}
	}
	
	/**
	 * 根据likelimit得到相关的sql或者hql
	 * @return null 表示没有likeLimit，返回字符串表示相关的模糊查询语句
	 */
	public String getLikeLimit() {
		if(StringUtils.isNotBlank(jb.getLikeLimit())){
				
				StringBuffer sb = new StringBuffer();
				
				String [] str = jb.getLikeLimit().split("=");
				for (int i = 0; i < str.length; i++) {
					
					
					//奇数为value，偶数为name
					if(i % 2 == 0){
						sb.append(str[i]);
					}else{
						String s = str[i].replaceAll("\'", "").replaceAll("\"", "").trim();
						sb.append(" like '%"+s+"%' and ");
					}
				}
				return sb.substring(0, sb.length()-4);
			}
			
			return null;
	}
	
	
	/**
	 * 得到精确地限制条件
	 * @return
	 */
	public String getLimit() {
		if(StringUtils.isNotBlank(jb.getLimit())){
			StringBuffer sb = new StringBuffer();
			//得到name = value
			String[] andSplit = jb.getLimit().split("and");

			for (int i = 0; i < andSplit.length; i++) {
				//得到name 和 value
				String [] equSplit = andSplit[i].split("=");
				
				for (int j = 0; j < equSplit.length; j++) {
					//奇书为value,只有value有值时，才把该查询添加进去
					if(j % 2 == 1){
						if(StringUtils.isNotBlank(equSplit[j].trim())){
							sb.append(" " + equSplit[j-1] + "=" +equSplit[j] + " and ");
						}
					}
				}
			}
			if(sb.length()>1){
				return sb.substring(0, sb.length()-4);
			}
			return null;
		}
		return null;
	}
	
}

