package com.oneflyingleaf.core.tag.tag;

import java.util.List;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.PageContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.oneflyingleaf.core.tag.utils.ClassUtils;


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
	 * �õ���Ӧ��list
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
		
		log.info("l:lists��ǩ:" + str);
		System.out.println("l:lists��ǩ:" + str);
		
		return list;
	}
	
	/**
	 * ���ַ���ֵ
	 * @return null ��ʾ���� ���isHqlΪtrue���򷵻�һ��hql��䣬���isHqlΪfalse�����ʾ����sql��䣬isHqlĬ��Ϊtrue;
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
		}else{//û��hql��sql��䣬ֱ��ͨ����ص����Դ����ֵ����ƴ�յõ�hql���
			StringBuffer sb = new StringBuffer();
			sb.append("from "+ name + " ");
			
			//ƴ��where���
			if(StringUtils.isNotBlank(limit) || StringUtils.isNotBlank(likeLimit) || StringUtils.isNotBlank(otherCon)){
				sb.append("where ");
				//ƴ�Ͼ�ȷ��ѯ���
				if(limitCheck && StringUtils.isNotBlank(getLimit())){
					sb.append(" "+getLimit()+" and ");
				}else if(StringUtils.isNotBlank(limit)){
					sb.append(" "+limit+" and ");
				}
				
				//ֱ�ӽ���Ӧ�����ݷ���where��
				if(StringUtils.isNotBlank(otherCon)){
					sb.append(" "+otherCon +" and ");
				}
				//ƴ��ģ����ѯ���
				if(StringUtils.isNotBlank(getLikeLimit())){
					sb.append(" "+getLikeLimit()+" and ");
				}
				//�����յ�where�Ӿ䴫��sb��
				sb = new StringBuffer(sb.substring(0, sb.length()-4));
			}
			
			//ƴ��order by�Ӿ�
			if(StringUtils.isNotBlank(order)){
				sb.append(" order by " + order);
			}
			
			return sb.toString();
		}
	}
	
	/**
	 * ����likelimit�õ���ص�sql����hql
	 * @return null ��ʾû��likeLimit�������ַ�����ʾ��ص�ģ����ѯ���
	 */
	public String getLikeLimit() {
		if(StringUtils.isNotBlank(likeLimit)){
				
				StringBuffer sb = new StringBuffer();
				
				String [] str = likeLimit.split("=");
				for (int i = 0; i < str.length; i++) {
					
					
					//����Ϊvalue��ż��Ϊname
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
	 * �õ���ȷ����������
	 * @return
	 */
	public String getLimit() {
		if(StringUtils.isNotBlank(limit)){
			StringBuffer sb = new StringBuffer();
			//�õ�name = value
			String[] andSplit = limit.split("and");

			for (int i = 0; i < andSplit.length; i++) {
				//�õ�name �� value
				String [] equSplit = andSplit[i].split("=");
				
				for (int j = 0; j < equSplit.length; j++) {
					//����Ϊvalue,ֻ��value��ֵʱ���ŰѸò�ѯ��ӽ�ȥ
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
