package com.oneflyingleaf.core.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.ContextLoaderListener;

import com.oneflyingleaf.core.data.SystemData;
import com.oneflyingleaf.core.init.FileInit;
import com.oneflyingleaf.core.util.ClassUtils;
import com.oneflyingleaf.core.util.SpringUtils;



public class GobalListener extends ContextLoaderListener implements HttpSessionListener,ServletContextListener{
	private Log log = LogFactory.getLog(GobalListener.class);

	public GobalListener(){
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		log.info("servletContext Ïú»Ù");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		log.info("servletContext ³õÊ¼»¯");
		
		SpringUtils.setServletContext(sce.getServletContext());

		ClassUtils.runMethod(FileInit.class,"init");
		
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		SystemData.onlineUser ++ ;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		SystemData.onlineUser --;
	}

}
