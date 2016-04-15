package com.oneflyingleaf.core.tag.bean;

public class AjaxBean {
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
	
	//��ʾ�Ƿ���Hql��ֹjavabean����
	private boolean hqlLan = true;
	
	//ÿҳ������
	private Integer pageCount;
	//ҳ��
	private Integer pageNow; 
	
	private Class clazz = null;
	
	//ʵ����İ��������ʵ����ȱʧ���Զ�Ѱ��config.properties���е�data.package����������packageName
	private String packageName;

	//�Ƿ�ֻ��һ����¼
	private boolean onlyOne = false;
	
	private boolean checkClass = true;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVar() {
		return var;
	}
	public void setVar(String var) {
		this.var = var;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getHql() {
		return hql;
	}
	public void setHql(String hql) {
		this.hql = hql;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLikeLimit() {
		return likeLimit;
	}
	public void setLikeLimit(String likeLimit) {
		this.likeLimit = likeLimit;
	}
	public String getOtherCon() {
		return otherCon;
	}
	public void setOtherCon(String otherCon) {
		this.otherCon = otherCon;
	}
	public boolean isLimitCheck() {
		return limitCheck;
	}
	public void setLimitCheck(boolean limitCheck) {
		this.limitCheck = limitCheck;
	}

	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getPageNow() {
		return pageNow;
	}
	public void setPageNow(Integer pageNow) {
		this.pageNow = pageNow;
	}
	public Class getClazz() {
		return clazz;
	}
	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public boolean isOnlyOne() {
		return onlyOne;
	}
	public void setOnlyOne(boolean onlyOne) {
		this.onlyOne = onlyOne;
	}
	public boolean isHqlLan() {
		return hqlLan;
	}
	public void setHqlLan(boolean hqlLan) {
		this.hqlLan = hqlLan;
	}
	public boolean isCheckClass() {
		return checkClass;
	}
	public void setCheckClass(boolean checkClass) {
		this.checkClass = checkClass;
	}
}
