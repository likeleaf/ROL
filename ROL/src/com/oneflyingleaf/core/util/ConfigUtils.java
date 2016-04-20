package com.oneflyingleaf.core.util;

import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;

public class ConfigUtils {
	private static final ResourceBundle rb = ResourceBundle.getBundle("config");
	
	/**
	 * 得到相关的组的公共文件的包
	 * @param name js或者css
	 * @return 
	 */
	public static String getCommonPackage(String name){
		
		return getString("init.common."+name+".package");
	}
	
	/**
	 * 得到相关的组的公共文件的名称
	 * @param name js或者css
	 * @return 
	 */
	public static String[] getCommonName(String name){
		String val = getString("init.common."+name+".name");
		return StringUtils.isNotBlank(val)?val.split("#"):null;
	}
	
	/**
	 * 得到相关的组的具体值
	 * @param name js或者css
	 * @return js或者css组内各个名称
	 */
	public static String[] getGroupName(String name){
		String value = getString("init."+name+".name");
		if(StringUtils.isBlank(value)){
			return null;
		}
		
		return value.split("#");
	}
	
	/**
	 * 得到js存放的包的相对路径
	 * @param group js的组别
	 * @return
	 */
	public static String getJsPackage(String group){
		return getString("init."+group+".js.package");
	}
	
	/**
	 * 得到js的名称
	 * @param group js的组别
	 * @return
	 */
	public static String[] getJsName(String group){
		String val = getString("init."+group+".js.name");
		return StringUtils.isNotBlank(val)?val.split("#"):null;
	}
	
	/**
	 * 得到js存放的包的相对路径
	 * @param group 组别
	 * @return
	 */
	public static String getCssPackage(String group){
		return getString("init."+group+".css.package");
	}
	
	/**
	 * 得到js的名称
	 * @param group css组别
	 * @return
	 */
	public static String[] getCssName(String group){
		return getString("init."+group+".css.name").split("#");
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
