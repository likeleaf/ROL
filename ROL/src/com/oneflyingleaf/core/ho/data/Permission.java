package com.oneflyingleaf.core.ho.data;

import java.io.Serializable;

public class Permission implements Serializable{
	private static final long serialVersionUID = -8703415748552108349L;

	
	private String permId ;
	private String rol;
	private String permCod ;
	private String permExp;
	
	
	public String getPermId() {
		return permId;
	}
	public void setPermId(String permId) {
		this.permId = permId;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getPermCod() {
		return permCod;
	}
	public void setPermCod(String permCod) {
		this.permCod = permCod;
	}
	public String getPermExp() {
		return permExp;
	}
	public void setPermExp(String permExp) {
		this.permExp = permExp;
	}
}
