package com.oneflyingleaf.core.util;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.oneflyingleaf.core.service.BaseService;

/**
 * Spring������
 * @author Administrator
 */
public class SpringUtils {
	
	public static ServletContext servletContext;
	public static int onLineUser = 0;
	
	/**
	 * �õ���ǰ��ApplicationContext
	 * @param sc ServletContext
	 * @return
	 */
	public static ApplicationContext getApplicationContext(ServletContext sc){
		return WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
	}
	
	/**
	 * �������еõ���Ӧ��Bean
	 * @param sc ServletContext
	 * @param obj ������Bean������
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(ServletContext sc,String obj){
		return (T) getApplicationContext(sc).getBean(obj);
	}
	
	
	/**
	 * �õ������е�baseService
	 * @return
	 */
	public static BaseService getBaseService(){
		return SpringUtils.getBean(getServletContext(), "baseService");
	}
	
	public static String getRealPath(String name){
		String realPath = getServletContext().getRealPath(name);
		return realPath;
	}
	
	public static ServletContext getServletContext() {
		return servletContext;
	}
	
	public static void setServletContext(ServletContext sc) {
		servletContext = sc;
	}
}
