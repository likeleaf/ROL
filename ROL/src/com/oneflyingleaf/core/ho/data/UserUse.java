package com.oneflyingleaf.core.ho.data;

import java.sql.Timestamp;

public class UserUse {
	
	private Integer userUseId;
	private String userUseKey;
	private String userUseValue;
	private String userId;
	private Timestamp userUseTime;
	private String userUseStat;
	
	
	public String getUserUseKey() {
		return userUseKey;
	}
	public void setUserUseKey(String userUseKey) {
		this.userUseKey = userUseKey;
	}
	public String getUserUseValue() {
		return userUseValue;
	}
	public void setUserUseValue(String userUseValue) {
		this.userUseValue = userUseValue;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Timestamp getUserUseTime() {
		return userUseTime;
	}
	public void setUserUseTime(Timestamp userUseTime) {
		this.userUseTime = userUseTime;
	}
	public String getUserUseStat() {
		return userUseStat;
	}
	public void setUserUseStat(String userUseStat) {
		this.userUseStat = userUseStat;
	}
	public Integer getUserUseId() {
		return userUseId;
	}
	public void setUserUseId(Integer userUseId) {
		this.userUseId = userUseId;
	}
}
