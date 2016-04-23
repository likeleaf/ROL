package com.oneflyingleaf.core.tag.controller.dispatcher;

import java.util.ArrayList;
import java.util.List;

import com.oneflyingleaf.core.tag.controller.query.Query;

public class Dispatcher {
	private List<Query> query = new ArrayList<Query>();
	
	public boolean addQuery(Query query){
		if(query == null){
			throw new NullPointerException();
		}
		
		return this.query.add(query);
	}
	
	
	
}
