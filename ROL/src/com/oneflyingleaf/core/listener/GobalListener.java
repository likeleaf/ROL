package com.oneflyingleaf.core.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.oneflyingleaf.core.init.FileInit;
import com.oneflyingleaf.core.util.ClassUtils;



public class GobalListener implements HttpSessionListener,ServletContextListener{

	public GobalListener(){
		ClassUtils.runMethod(FileInit.class,"init");
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
	}

}
