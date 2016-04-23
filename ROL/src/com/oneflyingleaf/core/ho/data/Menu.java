package com.oneflyingleaf.core.ho.data;

public class Menu {
	private Integer id;//主键
	private String title;
	private String Path;
	private String localPath;
	private Integer bookDetailId;
	private Integer menuIndex;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}

	public String getLocalPath() {
		return localPath;
	}
	public void setLocalPath(String localPath) {
		this.localPath = localPath;
	}
	public Integer getBookDetailId() {
		return bookDetailId;
	}
	public void setBookDetailId(Integer bookDetailId) {
		this.bookDetailId = bookDetailId;
	}
	public Integer getMenuIndex() {
		return menuIndex;
	}
	public void setMenuIndex(Integer menuIndex) {
		this.menuIndex = menuIndex;
	}

}
