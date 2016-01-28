package com.oneflyingleaf.core.tag.utils;

import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;

public class ClassUtils {
	
	private static ResourceBundle rb =  ResourceBundle.getBundle("config");
	
	
	
	/**
	 * 根据相关的name得到它的class，该name的包名必须在config中注册，key的值为data.package
	 * @param packageName 实体类的包名，如果实体类缺失将自动寻找config.properties的中的data.package属性来充作packageName
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
