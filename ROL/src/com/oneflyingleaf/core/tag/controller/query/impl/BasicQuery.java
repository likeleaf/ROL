package com.oneflyingleaf.core.tag.controller.query.impl;

import java.util.List;


import com.oneflyingleaf.core.tag.bean.AjaxBean;
import com.oneflyingleaf.core.tag.controller.query.Query;
import com.oneflyingleaf.core.tag.service.TagService;

public class BasicQuery implements Query {

	protected String finalHql = "";
	protected String hql = "";
	protected TagService tagService;
	
	

	@Override
	public <T> List<T> getList() {
		return null;
	}
}
