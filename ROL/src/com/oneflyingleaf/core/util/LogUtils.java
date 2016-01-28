package com.oneflyingleaf.core.util;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.oneflyingleaf.core.constant.SessionEnum;

public class LogUtils {
	static Log log = LogFactory.getLog(LogUtils.class);
	
	public static void log(String code,String info,LogType type,String ip){
		HttpServletRequest req = ServletActionContext.getRequest();
		String id = (String) req.getSession().getAttribute(SessionEnum.USERID.toString());
		if(ip == null){
			ip = req.getRemoteAddr();
		}
		switch(type){
		  case ERROR:
			  saveLog(code,info,LogType.ERROR.toString(),ip,id);
			  log.error(info);
			  break;
		  case INFO:
			 log.info(info);
			 break;
		  case WARN:
			  log.warn(info);
		}
		
	}
	
	
	private static void saveLog(String logCode,String logDes,String logIp,String logType,String userId){
		com.oneflyingleaf.core.ho.data.Log l = new com.oneflyingleaf.core.ho.data.Log(null,logCode,logDes,logIp,new Timestamp(System.currentTimeMillis()),logType,userId);
		SpringUtils.getBaseDao().save(l);
	}
	public static void info(String code,String info,String ip){
		log(code,info,LogType.INFO,ip);
	}
	
	public static void info(String code,String info){
		log(code,info,LogType.INFO,null);
	}
	
	public static void error(String code,String info,String ip){
		log(code,info,LogType.INFO,ip);
	}
	
	public static void error(String code,String info){
		log(code,info,LogType.ERROR,null);
	}
	
	public static void warn(String code,String info,String ip){
		log(code,info,LogType.WARN,ip);
	}
	
	public static void warn(String code,String info){
		log(code,info,LogType.WARN,null);
	}
	
	private enum LogType{
		INFO,ERROR,WARN;
	}
}
