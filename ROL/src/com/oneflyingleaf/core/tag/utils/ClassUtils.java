package com.oneflyingleaf.core.tag.utils;

import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;

public class ClassUtils {
	
	private static ResourceBundle rb =  ResourceBundle.getBundle("config");
	
	
	
	/**
	 * ������ص�name�õ�����class����name�İ���������config��ע�ᣬkey��ֵΪdata.package
	 * @param packageName ʵ����İ��������ʵ����ȱʧ���Զ�Ѱ��config.properties���е�data.package����������packageName
	 * @param name
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static Class getClass(String name,String packageName) throws ClassNotFoundException{
		
		try {
			String clazzName = (StringUtils.isNotBlank(packageName)?packageName:rb.getString("data.package")) +  "." + name;
			return Class.forName(clazzName);
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException();
		}
	}
	
	
	
}
