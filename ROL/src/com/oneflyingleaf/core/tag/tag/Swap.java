package com.oneflyingleaf.core.tag.tag;

import java.io.IOException;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.oneflyingleaf.core.tag.utils.ContextUtils;


/**
 * 将特定的值交换为对应的值，该值需要在ContextUtil中配置
 * @author leaf
 *
 */
public class Swap extends SimpleTagSupport{

	//需要交换名
	private String key;
	//属性标签值
	private String value;
	
	
	
	@Override
	public void doTag() throws JspException, IOException {
		
		Map<String, String> map = ContextUtils.getMap().get(key);
		
		PageContext jc = (PageContext) this.getJspContext();
		
		JspWriter out = jc.getOut();
		
		out.write(map.get(value));
	}



	public void setKey(String key) {
		this.key = key;
	}



	public void setValue(String value) {
		this.value = value;
	}
	
}
