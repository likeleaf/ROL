package com.oneflyingleaf.core.tag.tag;

import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.oneflyingleaf.core.tag.service.TagService;


public class BasicTag extends SimpleTagSupport{
	
	protected static TagService tagService;
	protected static Log log = LogFactory.getLog(BasicTag.class);
	
	static{
		log.info("BasicTag ��ʼ��...");
	//	System.out.println("BasicTag ��ʼ��...");
	}

	public TagService getTagService() {
		return tagService;
	}

	public void setTagService(TagService tagService) {
		this.tagService = tagService;
	}
}
