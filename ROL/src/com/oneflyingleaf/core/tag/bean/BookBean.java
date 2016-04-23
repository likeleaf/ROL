package com.oneflyingleaf.core.tag.bean;

public class BookBean extends AjaxBean{
	
	//是否将章节加入到book中，10 不加  20 加载最新章节 30 加载所有章节
	private String addBookChaper  = "10";
	
	//hql语句中是否已经加入了相关的字段，只有在addBookChaper不为10时有效
	private boolean hasAllSelect = false;
	
	private String sellectFiled = "";

	public String getAddBookChaper() {
		return addBookChaper;
	}

	public void setAddBookChaper(String addBookChaper) {
		this.addBookChaper = addBookChaper;
	}

	public boolean isHasAllSelect() {
		return hasAllSelect;
	}

	public void setHasAllSelect(boolean hasAllSelect) {
		this.hasAllSelect = hasAllSelect;
	}

	public String getSellectFiled() {
		return sellectFiled;
	}

	public void setSellectFiled(String sellectFiled) {
		this.sellectFiled = sellectFiled;
	}
	
	
}
