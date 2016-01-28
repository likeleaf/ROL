package com.oneflyingleaf.core.tag.utils;

import java.util.HashMap;
import java.util.Map;

public class ContextUtils {
	private static Map<String,Map<String,String>> SELECT_MAP = new HashMap<String,Map<String,String>>();
	
	
	public static Map<String,Map<String,String>> getMap(){
		Map<String,String> map = new HashMap<String,String>();
		
		//将sex放入容器中，1 男  ；0  女
		map.put(" ", "请选择");
		map.put("1", "男");
		map.put("0", "女");
		
		SELECT_MAP.put("SEX", map);
		return SELECT_MAP;
	}

}
