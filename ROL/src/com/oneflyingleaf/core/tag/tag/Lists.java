package com.oneflyingleaf.core.tag.tag;

import java.util.List;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.PageContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.oneflyingleaf.core.tag.utils.ClassUtils;


public class Lists extends BasicTag{
	
	
	//javaBean 的名称，必选
	private String name;
	//将list赋值
	private String var;
	//限制条件where条件，精确查询，只支持用=相连的
	private String limit;
	//排序
	private String order;
	//当type为hql是执行该hql
	private String hql;
	//当type为sql时执行该sql
	private String sql;
	//设定更新的类型
	private String type;
	//模糊查询
	private String likeLimit;
	
	//其他查询，任意查询，不做任何判断，直接加入where子句
	private String otherCon;
	
	//limit是否验证，如果验证的话可能会影响性能，默认是为false
	private boolean limitCheck = false;
	
	//表示是否是Hql
	private boolean isHql = true;
	
	//每页的数据
	private Integer pageCount;
	//页数
	private Integer pageNow; 
	
	private Class clazz = null;
	
	//实体类的包名，如果实体类缺失将自动寻找config.properties的中的data.package属性来充作packageName
	private String packageName;

	//是否只有一条记录
	private boolean onlyOne = false;
	//标签存放的域
	private String scope ;
	//标签存放的域中的名称，不设置为var
	private String sname;
	
	
	private JspContext pc;
	
	private static Log log = LogFactory.getLog(Lists.class);
	
	
	
	@Override
	public void setJspContext(JspContext pc) {
		this.pc = pc;
	}
	
	@Override
	public void doTag() throws javax.servlet.jsp.JspException ,java.io.IOException {
		try {
			clazz = ClassUtils.getClass(name,packageName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if(onlyOne){
			if (getList().size() > 0){
				pc.setAttribute(var,getList().get(0));
			}
		}
		
		String str = StringUtils.isNotBlank(sname)?sname:var;
		if("session".equals(scope)){
			((PageContext)this.getJspContext()).getSession().setAttribute(str, getList());
		}else{
			pc.setAttribute(str, getList());
		}
	}
	
	
	/**
	 * 得到相应的list
	 */
	private  List getList(){
		List list = null;
		
		String str = getQueryString();

		if(isHql){
				list = tagService.list(str,pageNow,pageCount);
		}else{
			try {
				list = tagService.listBySql(str,clazz.newInstance());
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		log.info("l:lists标签:" + str);
		System.out.println("l:lists标签:" + str);
		
		return list;
	}
	
	/**
	 * 三种返回值
	 * @return null 表示出错， 如果isHql为true，则返回一个hql语句，如果isHql为false，则表示返回sql语句，isHql默认为true;
	 */
	
	private String getQueryString(){
		if(StringUtils.isNotBlank(type)){
			if("hql".equals(type)){
				return hql;
			}else if("sql".equals(type)){
				isHql = false;
				return sql;
			}
			return null;
		}else{//没有hql和sql语句，直接通过相关的属性传入的值进行拼凑得到hql语句
			StringBuffer sb = new StringBuffer();
			sb.append("from "+ name + " ");
			
			//拼合where语句
			if(StringUtils.isNotBlank(limit) || StringUtils.isNotBlank(likeLimit) || StringUtils.isNotBlank(otherCon)){
				sb.append("where ");
				//拼合精确查询语句
				if(limitCheck && StringUtils.isNotBlank(getLimit())){
					sb.append(" "+getLimit()+" and ");
				}else if(StringUtils.isNotBlank(limit)){
					sb.append(" "+limit+" and ");
				}
				
				//直接将相应的数据放入where中
				if(StringUtils.isNotBlank(otherCon)){
					sb.append(" "+otherCon +" and ");
				}
				//拼合模糊查询语句
				if(StringUtils.isNotBlank(getLikeLimit())){
					sb.append(" "+getLikeLimit()+" and ");
				}
				//将最终的where子句传入sb中
				sb = new StringBuffer(sb.substring(0, sb.length()-4));
			}
			
			//拼合order by子句
			if(StringUtils.isNotBlank(order)){
				sb.append(" order by " + order);
			}
			
			return sb.toString();
		}
	}
	
	/**
	 * 根据likelimit得到相关的sql或者hql
	 * @return null 表示没有likeLimit，返回字符串表示相关的模糊查询语句
	 */
	public String getLikeLimit() {
		if(StringUtils.isNotBlank(likeLimit)){
				
				StringBuffer sb = new StringBuffer();
				
				String [] str = likeLimit.split("=");
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
		if(StringUtils.isNotBlank(limit)){
			StringBuffer sb = new StringBuffer();
			//得到name = value
			String[] andSplit = limit.split("and");

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
			
			return sb.substring(0, sb.length()-4);
		}
		return null;
	}


	public void setOnlyOne(boolean onlyOne) {this.onlyOne = onlyOne;}
	public void setName(String name) {
		this.name = name;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public void setHql(String hql) {
		this.hql = hql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setLikeLimit(String likeLimit) {
		this.likeLimit = likeLimit;
	}
	public void setOtherCon(String otherCon) {
		this.otherCon = otherCon;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public void setPageNow(Integer pageNow) {
		this.pageNow = pageNow;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public void setLimitCheck(boolean limitCheck) {
		this.limitCheck = limitCheck;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}




}
