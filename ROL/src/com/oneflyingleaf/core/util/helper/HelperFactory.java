package com.oneflyingleaf.core.util.helper;

import java.lang.reflect.Constructor;

public class HelperFactory {
	
	public static QueryHelper createQueryHelper(Class<?> clazz ,String s){
		try {
			Class<?> c = Class.forName("com.oneflyingleaf.core.util.helper.impl.QueryHelperImpl");
		
			Constructor<?> con = c.getConstructors()[0];
		
			return (QueryHelper) con.newInstance(clazz,s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
