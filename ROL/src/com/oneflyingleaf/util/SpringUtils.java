package com.oneflyingleaf.util;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.oneflyingleaf.dao.BaseDao;

/**
 * Spring������
 * @author Administrator
 */
public class SpringUtils {
	
	
	
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
	 * �õ������е�baseDao
	 * @return
	 */
	public static BaseDao getBaseDao(){
		return SpringUtils.getBean(ServletActionContext.getServletContext(), "baseDao");
	}
}
