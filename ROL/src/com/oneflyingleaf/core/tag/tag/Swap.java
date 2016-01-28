package com.oneflyingleaf.core.tag.tag;

import java.io.IOException;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.oneflyingleaf.core.tag.utils.ContextUtils;


/**
 * ���ض���ֵ����Ϊ��Ӧ��ֵ����ֵ��Ҫ��ContextUtil������
 * @author leaf
 *
 */
public class Swap extends SimpleTagSupport{

	//��Ҫ������
	private String key;
	//���Ա�ǩֵ
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
