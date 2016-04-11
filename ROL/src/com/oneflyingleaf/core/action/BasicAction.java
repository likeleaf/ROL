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
	 * ������s����ǰ̨
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
	 * ��json����ǰ̨
	 * 
	 */
	public void outPut(JSONObject jo){
		this.outPut(jo.toString());
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
	 * ��ȡ���ֵ
	 * @param key
	 * @return
	 */
	public String[] getParameterValues(String key){
		return getRequest().getParameterValues(key);
	}

	/**
	 * ��session��ȡ�ö�Ӧ��ֵ
	 * @param key
	 * @return
	 */
	public Object getSessionAttribute(String key){
		return getSession(true).getAttribute(key);
	}
	
	/**
	 * ��ֵ����session��
	 * @param key
	 * @param value
	 */
	public void setSessionAttribute(String key,Object value){
		getSession(true).setAttribute(key, value);
	}
	
	/**
	 * ɾ����ǰ��session
	 */
	public void deleteSession(){
		getSession(true).invalidate();
	}
	
	

}
