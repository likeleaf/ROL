package com.oneflyingleaf.core.constant;

public enum LogCod {
	DeleteUser("10","用户删除"),
	DeleteUserLogistic("11","用户逻辑删除");
	
	private String key;
	private String value;
	LogCod(String key,String value){
		this.key = key;
		this.value = value;
	}
	
	public String getKey(){
		return this.key;
	}
	
	public String getValue(){
		return this.value;
	}
}
