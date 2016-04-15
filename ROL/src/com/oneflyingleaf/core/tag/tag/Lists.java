package com.oneflyingleaf.core.tag.tag;

import java.util.List;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.PageContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.oneflyingleaf.core.tag.bean.AjaxBean;
import com.oneflyingleaf.core.tag.controller.ListDeal;


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
	//是否验证类
	private boolean checkClass = true;
	
	private JspContext pc;
	
	private static Log log = LogFactory.getLog(Lists.class);
	
	
	
	
	@Override
	public void setJspContext(JspContext pc) {
		this.pc = pc;
	}
	
	@Override
	public void doTag() throws javax.servlet.jsp.JspException ,java.io.IOException {
		
		AjaxBean jb = new AjaxBean();
		jb.setClazz(clazz);
		jb.setHql(hql);
		jb.setHqlLan(isHql);
		jb.setLikeLimit(likeLimit);
		jb.setLimitCheck(limitCheck);
		jb.setLimit(limit);
		jb.setName(name);
		jb.setOnlyOne(onlyOne);
		jb.setOrder(order);
		jb.setOtherCon(otherCon);
		jb.setPackageName(packageName);
		jb.setPageCount(pageCount);
		jb.setPageNow(pageNow);
		jb.setSql(sql);
		jb.setType(type);
		jb.setVar(var);
		jb.setCheckClass(checkClass);
		
		long  l1 = System.currentTimeMillis();
		ListDeal q = new ListDeal(jb);
		List l = q.getList();
	
		if(onlyOne){
			if (l.size() > 0){
				pc.setAttribute(var,l.get(0));
			}
		}
		
		System.out.println(System.currentTimeMillis() - l1);
		String str = StringUtils.isNotBlank(sname)?sname:var;
		if("session".equals(scope)){
			((PageContext)this.getJspContext()).getSession().setAttribute(str,l);
		}else{
			pc.setAttribute(str, l);
		}
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

	public void setCheckClass(boolean checkName) {
		this.checkClass = checkName;
	}




}
