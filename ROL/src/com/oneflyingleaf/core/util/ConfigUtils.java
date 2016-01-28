package com.oneflyingleaf.core.util;

import java.util.ResourceBundle;

public class ConfigUtils {
	private static final ResourceBundle rb = ResourceBundle.getBundle("config");
	
	
	
	
	/**
	 * 得到js存放的包的相对路径
	 * @return
	 */
	public static String getJsPackage(){
		return getString("init.js.package");
	}
	
	/**
	 * 得到js的名称
	 * @return
	 */
	public static String[] getJsName(){
		return getString("init.js.name").split("#");
	}
	
	/**
	 * 得到js存放的包的相对路径
	 * @return
	 */
	public static String getCssPackage(){
		return getString("init.css.package");
	}
	
	/**
	 * 得到js的名称
	 * @return
	 */
	public static String[] getCssName(){
		return getString("init.css.name").split("#");
	}
	/**
	 * 根据key值得到相关的value
	 * @param key
	 * @return
	 */
	public static String getString(String key){
		return rb.getString(key);
	}
}
