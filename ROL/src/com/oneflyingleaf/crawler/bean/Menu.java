package com.oneflyingleaf.crawler.bean;

public class Menu {
	private Integer id;
	private String title;
	private String Path;
	private String localPath;
	
	
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
}
