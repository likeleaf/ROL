package com.oneflyingleaf.core.tag.ajax;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.oneflyingleaf.core.action.BasicAction;
import com.oneflyingleaf.core.tag.bean.AjaxBean;
import com.oneflyingleaf.core.tag.controller.ListDeal;

public class AjaxAction extends BasicAction{
	
	private static final long serialVersionUID = 6042049007169357974L;
	
	Log log = LogFactory.getLog(AjaxAction.class);
	

	public void ajax(){
		String json = this.getParameter("json");
		try {
			json = URLDecoder.decode(json, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AjaxBean jb = JSON.parseObject(json, AjaxBean.class);
		ListDeal q = new ListDeal(jb);
		List l = q.getList();
		JSONObject jo = new JSONObject();
		if(jb.isShowCount()){
		   jo.put("count", q.getCount());
		}
		jo.put("pojo",l );
		this.outPut(jo.toJSONString());
	}
	
	public void book(){
		
	}
	
}
