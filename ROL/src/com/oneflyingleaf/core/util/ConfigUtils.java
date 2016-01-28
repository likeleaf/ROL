package com.oneflyingleaf.core.util;

import java.util.ResourceBundle;

public class ConfigUtils {
	private static final ResourceBundle rb = ResourceBundle.getBundle("config");
	
	
	
	
	/**
	 * �õ�js��ŵİ������·��
	 * @return
	 */
	public static String getJsPackage(){
		return getString("init.js.package");
	}
	
	/**
	 * �õ�js������
	 * @return
	 */
	public static String[] getJsName(){
		return getString("init.js.name").split("#");
	}
	
	/**
	 * �õ�js��ŵİ������·��
	 * @return
	 */
	public static String getCssPackage(){
		return getString("init.css.package");
	}
	
	/**
	 * �õ�js������
	 * @return
	 */
	public static String[] getCssName(){
		return getString("init.css.name").split("#");
	}
	/**
	 * ����keyֵ�õ���ص�value
	 * @param key
	 * @return
	 */
	public static String getString(String key){
		return rb.getString(key);
	}
}
