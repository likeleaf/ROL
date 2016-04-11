package com.oneflyingleaf.core.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.oneflyingleaf.core.service.BaseService;
import com.opensymphony.xwork2.ActionSupport;

public class BasicAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1259813891352194863L;
	
	@Resource(name="baseService")
	protected BaseService basicService;
	
	
	/**
	 * 将数据s传到前台
	 * @param s
	 */
	public void outPut(String s){
		
		ServletOutputStream os = null;
		try {
			os = getResponse().getOutputStream();
		
			os.write(s.getBytes("utf-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(os != null){
					os.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	/**
	 * 将json传到前台
	 * 
	 */
	public void outPut(JSONObject jo){
		this.outPut(jo.toString());
	}
	
	/**
	 * 得到request
	 * @return
	 */
	public HttpServletRequest getRequest(){
		return  ServletActionContext.getRequest();
	}
	
	
	/**
	 * 得到response
	 */
	public HttpServletResponse getResponse(){
		return ServletActionContext.getResponse();
	}
	
	/**
	 * 得到session,没有不创建
	 */
	public HttpSession getSession(){
		return getSession(false);
	}
	
	/**
	 * 得到session
	 * @param b
	 * @return
	 */
	public HttpSession getSession(boolean b){
		return ServletActionContext.getRequest().getSession(b);
	}
	
	
	/**
	 * 从request得到相应的值
	 * @param key
	 * @return
	 */
	public String getParameter(String key){
		return getRequest().getParameter(key);
	}
	
	/**
	 * 设置值到request中
	 * @param key
	 * @param value
	 */
	public void setParameter(String key,String value){
		getRequest().setAttribute(key, value);
	}
	
	/**
	 * 获取多个值
	 * @param key
	 * @return
	 */
	public String[] getParameterValues(String key){
		return getRequest().getParameterValues(key);
	}

	/**
	 * 从session中取得对应的值
	 * @param key
	 * @return
	 */
	public Object getSessionAttribute(String key){
		return getSession(true).getAttribute(key);
	}
	
	/**
	 * 将值放入session中
	 * @param key
	 * @param value
	 */
	public void setSessionAttribute(String key,Object value){
		getSession(true).setAttribute(key, value);
	}
	
	/**
	 * 删除当前的session
	 */
	public void deleteSession(){
		getSession(true).invalidate();
	}
	
	

}
