package com.oneflyingleaf.core.util;

import java.lang.reflect.Method;

public class ClassUtils {
	
	/**
	 * ִ�ж����еķ���
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
