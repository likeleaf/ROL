package com.oneflyingleaf.core.tag.utils;

import java.util.HashMap;
import java.util.Map;

public class ContextUtils {
	private static Map<String,Map<String,String>> SELECT_MAP = new HashMap<String,Map<String,String>>();
	
	
	public static Map<String,Map<String,String>> getMap(){
		Map<String,String> map = new HashMap<String,String>();
		
		//��sex���������У�1 ��  ��0  Ů
		map.put(" ", "��ѡ��");
		map.put("1", "��");
		map.put("0", "Ů");
		
		SELECT_MAP.put("SEX", map);
		return SELECT_MAP;
	}

}
