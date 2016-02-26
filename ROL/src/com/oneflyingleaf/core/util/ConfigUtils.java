package com.oneflyingleaf.core.util;

import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;

public class ConfigUtils {
	private static final ResourceBundle rb = ResourceBundle.getBundle("config");
	
	/**
	 * �õ���ص���Ĺ����ļ��İ�
	 * @param name js����css
	 * @return 
	 */
	public static String getCommonPackage(String name){
		
		return getString("init.common."+name+".package");
	}
	
	/**
	 * �õ���ص���Ĺ����ļ�������
	 * @param name js����css
	 * @return 
	 */
	public static String[] getCommonName(String name){
		String val = getString("init.common."+name+".name");
		return StringUtils.isNotBlank(val)?val.split("#"):null;
	}
	
	/**
	 * �õ���ص���ľ���ֵ
	 * @param name js����css
	 * @return js����css���ڸ�������
	 */
	public static String[] getGroupName(String name){
		String value = getString("init."+name+".name");
		if(StringUtils.isBlank(value)){
			return null;
		}
		
		return value.split("#");
	}
	
	/**
	 * �õ�js��ŵİ������·��
	 * @param group js�����
	 * @return
	 */
	public static String getJsPackage(String group){
		return getString("init."+group+".js.package");
	}
	
	/**
	 * �õ�js������
	 * @param group js�����
	 * @return
	 */
	public static String[] getJsName(String group){
		String val = getString("init."+group+".js.name");
		return StringUtils.isNotBlank(val)?val.split("#"):null;
	}
	
	/**
	 * �õ�js��ŵİ������·��
	 * @param group ���
	 * @return
	 */
	public static String getCssPackage(String group){
		return getString("init."+group+".css.package");
	}
	
	/**
	 * �õ�js������
	 * @param group css���
	 * @return
	 */
	public static String[] getCssName(String group){
		return getString("init."+group+".css.name").split("#");
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
