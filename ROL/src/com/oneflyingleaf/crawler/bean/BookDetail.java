package com.oneflyingleaf.crawler.bean;

import java.util.List;

public class BookDetail {
	
	private Integer bookDetailId;
	//ͼƬ��ַ
	private String picturePath;
	//����
	private String bookName;
	//�鼮Ŀ¼·������menuPath
	@Deprecated
	private String bookPath;
	//�鼮��ǩ
	private String bookLab;
	//����
	private String auth;
	//���
	private String intro;
	//�����ʱ��
	private String time;
	//Ŀ¼��·��
	private String menuPath;
	//ͼƬ����·��
	private String picLocalPath;
	//�½�
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
