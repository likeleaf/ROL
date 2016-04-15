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
	
	
	//javaBean �����ƣ���ѡ
	private String name;
	//��list��ֵ
	private String var;
	//��������where��������ȷ��ѯ��ֻ֧����=������
	private String limit;
	//����
	private String order;
	//��typeΪhql��ִ�и�hql
	private String hql;
	//��typeΪsqlʱִ�и�sql
	private String sql;
	//�趨���µ�����
	private String type;
	//ģ����ѯ
	private String likeLimit;
	
	//������ѯ�������ѯ�������κ��жϣ�ֱ�Ӽ���where�Ӿ�
	private String otherCon;
	
	//limit�Ƿ���֤�������֤�Ļ����ܻ�Ӱ�����ܣ�Ĭ����Ϊfalse
	private boolean limitCheck = false;
	
	//��ʾ�Ƿ���Hql
	private boolean isHql = true;
	
	//ÿҳ������
	private Integer pageCount;
	//ҳ��
	private Integer pageNow; 
	
	private Class clazz = null;
	
	//ʵ����İ��������ʵ����ȱʧ���Զ�Ѱ��config.properties���е�data.package����������packageName
	private String packageName;

	//�Ƿ�ֻ��һ����¼
	private boolean onlyOne = false;
	//��ǩ��ŵ���
	private String scope ;
	//��ǩ��ŵ����е����ƣ�������Ϊvar
	private String sname;
	//�Ƿ���֤��
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
