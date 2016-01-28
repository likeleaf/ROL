package com.oneflyingleaf.core.tag.tag;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import com.oneflyingleaf.core.tag.utils.ContextUtils;


public class Select extends BasicTag{
	
	private String key;
	private String name;
	private String value;

	@Override
	public void doTag() throws JspException, IOException {
		JspContext pc = this.getJspContext();
		JspWriter out = pc.getOut();
		
		StringBuffer sb = new StringBuffer();
		sb.append("<select name=\"" + name +"\" data-role='none'>");
		
		Map<String, String> map = ContextUtils.getMap().get(key);
		Set<String> keySet = map.keySet();

		for (String str : keySet) {
			if(str.equals(value)){
				sb.append("<option value=\""+str+"\" selected=\"selected\">"+map.get(str)+"</option>");	
			}else{
				sb.append("<option value=\""+str+"\">"+map.get(str)+"</option>");	
			}
		}
		sb.append("</select>");
		out.write(sb.toString());
		
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
