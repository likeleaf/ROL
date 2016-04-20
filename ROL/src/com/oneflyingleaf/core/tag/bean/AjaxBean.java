package com.oneflyingleaf.core.tag.bean;

public class AjaxBean {
	//javaBean 的名称，必选
	protected String name;
	//将list赋值
	protected String var;
	//限制条件where条件，精确查询，只支持用=相连的
	protected String limit;
	//排序
	protected String order;
	//当type为hql是执行该hql
	protected String hql;
	//当type为sql时执行该sql
	protected String sql;
	//设定更新的类型
	protected String type;
	//模糊查询
	protected String likeLimit;
	
	//其他查询，任意查询，不做任何判断，直接加入where子句
	protected String otherCon;
	
	//limit是否验证，如果验证的话可能会影响性能，默认是为false
	protected boolean limitCheck = false;
	
	//表示是否是Hql防止javabean问题
	protected boolean hqlLan = true;
	
	//每页的数据
	protected Integer pageCount;
	//页数
	protected Integer pageNow; 
	
	protected Class clazz = null;
	
	//实体类的包名，如果实体类缺失将自动寻找config.properties的中的data.package属性来充作packageName
	protected String packageName;

	//是否只有一条记录
	protected boolean onlyOne = false;
	
	protected boolean checkClass = true;
	//是否获取总数，如果获取则得到count:123
	protected boolean showCount = false;

	
	
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
	public boolean isShowCount() {
		return showCount;
	}
	public void setShowCount(boolean showCount) {
		this.showCount = showCount;
	}

}
