package com.oneflyingleaf.core.constant;

public enum LogCod {
	DeleteUser("10","�û�ɾ��"),
	DeleteUserLogistic("11","�û��߼�ɾ��");
	
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
