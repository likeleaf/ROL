package com.oneflyingleaf.core.util;

import java.lang.reflect.Method;

public class ClassUtils {
	
	/**
	 * 执行对象中的方法
	 * @param clazz
	 * @param methodName
	 */
	public static void runMethod(Class<?> clazz , String methodName){
		try {
			Method method = clazz.getMethod(methodName, null);
			method.invoke(clazz.newInstance(), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
