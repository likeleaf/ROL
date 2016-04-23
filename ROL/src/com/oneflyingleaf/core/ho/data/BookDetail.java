package com.oneflyingleaf.core.ho.data;

import java.util.List;

public class BookDetail {
	
	private Integer bookDetailId;
	//图片地址
	private String picturePath;
	//书名
	private String bookName;
	//书籍目录路径换成menuPath
	@Deprecated
	private String bookPath;
	//书籍标签
	private String bookLab;
	//作者
	private String auth;
	//简介
	private String intro;
	//最近的时间
	private String time;
	//目录的路径
	private String menuPath;
	//图片本地路径
	private String picLocalPath;
	//章节
	private List<Menu> menu;
	
	
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	@Deprecated
	public String getBookPath() {
		return bookPath;
	}
	@Deprecated
	public void setBookPath(String bookPath) {
		this.bookPath = bookPath;
	}
	public String getBookLab() {
		return bookLab;
	}
	public void setBookLab(String bookLab) {
		this.bookLab = bookLab;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMenuPath() {
		return menuPath;
	}
	public void setMenuPath(String menuPath) {
		this.menuPath = menuPath;
	}
	@Override
	public String toString() {
		return "BookDetail [picturePath=" + picturePath + ", bookName="
				+ bookName + ", bookPath=" + bookPath + ", bookLab=" + bookLab
				+ ", auth=" + auth + ", intro=" + intro + ", time=" + time
				+ ", menuPath=" + menuPath + ", menu=" + menu + "]";
	}
	public List<Menu> getMenu() {
		return menu;
	}
	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}
	public Integer getBookDetailId() {
		return bookDetailId;
	}
	public void setBookDetailId(Integer bookDetailId) {
		this.bookDetailId = bookDetailId;
	}
	public String getPicLocalPath() {
		return picLocalPath;
	}
	public void setPicLocalPath(String picLocalPath) {
		this.picLocalPath = picLocalPath;
	}
}
