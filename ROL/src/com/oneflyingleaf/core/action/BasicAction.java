package com.oneflyingleaf.core.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.http.HttpRequest;

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
	 * ������s����ǰ̨
	 * @param s
	 */
	public void outPut(String s){
		
		ServletOutputStream os = null;
		try {
			os = getResponse().getOutputStream();
		
			os.write(s.getBytes("utf-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
	 * �õ�request
	 * @return
	 */
	public HttpServletRequest getRequest(){
		return  ServletActionContext.getRequest();
	}
	
	
	/**
	 * �õ�response
	 */
	public HttpServletResponse getResponse(){
		return ServletActionContext.getResponse();
	}
	
	/**
	 * �õ�session,û�в�����
	 */
	public HttpSession getSession(){
		return getSession(false);
	}
	
	/**
	 * �õ�session
	 * @param b
	 * @return
	 */
	public HttpSession getSession(boolean b){
		return ServletActionContext.getRequest().getSession(b);
	}
	
	
	/**
	 * ��request�õ���Ӧ��ֵ
	 * @param key
	 * @return
	 */
	public String getParameter(String key){
		return getRequest().getParameter(key);
	}
	
	/**
	 * ����ֵ��request��
	 * @param key
	 * @param value
	 */
	public void setParameter(String key,String value){
		getRequest().setAttribute(key, value);
	}

	/**
	 * ��session��ȡ�ö�Ӧ��ֵ
	 * @param key
	 * @return
	 */
	public Object getAttribute(String key){
		return getSession(true).getAttribute(key);
	}
	
	/**
	 * ��ֵ����session��
	 * @param key
	 * @param value
	 */
	public void setAttribute(String key,String value){
		getSession(true).setAttribute(key, value);
	}
	
	/**
	 * ɾ����ǰ��session
	 */
	public void deleteSession(){
		getSession(true).setMaxInactiveInterval(-1);
	}
}
