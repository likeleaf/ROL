package com.oneflyingleaf.core.tag.tag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspWriter;

import org.apache.commons.lang3.StringUtils;


public class Count extends BasicTag {
	
	private String name;
	private String var;
	
	private JspContext pc;
	
	@Override
	public void doTag() throws javax.servlet.jsp.JspException ,java.io.IOException {
		
		int count = tagService.getCount(name);
		
		if(StringUtils.isNotBlank(var)){
			pc.setAttribute(var, count);
		}else{
			JspWriter out = pc.getOut();
			out.write(""+count);
		}
	}
	
	
	@Override
	public void setJspContext(javax.servlet.jsp.JspContext pc) {
		this.pc = pc;
	}

	
	
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setVar(String var) {
		this.var = var;
	}
	
	
}
