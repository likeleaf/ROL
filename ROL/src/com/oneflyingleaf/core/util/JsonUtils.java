package com.oneflyingleaf.core.util;

import net.sf.json.JSONObject;

public class JsonUtils {
	
	
	
	/**
	 * 将值转换成json格式在转成String
	 * @param jo
	 * @param key
	 * @param value
	 * @return
	 */
	public static String toJsonString(JSONObject jo,String key,Object value){
		if(jo == null){
			jo = new JSONObject();
		}
		jo.put(key, value);
		return jo.toString();
	}
	
	
	/**
	 * 将值转换成json格式在转成String
	 * @param jo
	 * @param key
	 * @param value
	 * @return
	 */
	public static String toJsonString(String keyValues){
		
		return toStringMore(null,keyValues).toString();
	}
	
	/**
	 * 将值转换成json格式在转成String
	 * @param jo
	 * @param key
	 * @param value
	 * @return
	 */
	public static String toJsonString(String key,Object value){
		return toJsonString(null, key,value);
	}
	
	
	/**
	 * 将值转换成json格式
	 * @param jo
	 * @param key
	 * @param value
	 * @return
	 */
	public static JSONObject toJsonObject(JSONObject jo,String key,Object value){

		return toJsonObjectMore(jo ,new String[]{key},new Object[]{value});
	}
	
	/**
	 * 将两个值转成josn格式
	 * @param jo
	 * @param key
	 * @param value
	 * @param key2
	 * @param value2
	 * @return
	 */
	public static JSONObject toJsonObject2(JSONObject jo,String key,Object value,String key2,Object value2){
		
	
		return toJsonObjectMore(jo ,new String[]{key,key2},new Object[]{value,value2});
	}
	
	/**
	 * 将多个值转成josn格式
	 * @param jo
	 * @param key
	 * @param value
	 * @param key2
	 * @param value2
	 * @return
	 */
	public static JSONObject toJsonObjectMore(JSONObject jo,String []key,Object []value){
		if(jo == null){
			jo = new JSONObject();
		}
		if(key.length != value.length){
			try{
				new Exception("key的长度与value的长度不一致");
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
		
		for(int i = 0;i<key.length ;i++){
			jo.put(key[i], value[i]);
		}
		
		return jo;
	}
	
	
	/**
	 * 将类似于json格式的转换成json
	 * @param jo
	 * @param keyValues  stat:suc,mag:suc
	 * @return
	 */
	public static String toStringMore(JSONObject jo,String keyValues){
		if(jo == null){
			jo = new JSONObject();
		}
		String []keyAndValues = keyValues.split(",");
		String [] str = null; 
		for(String  keyAndValue : keyAndValues){
			str = keyAndValue.split(":");
			jo.put(str[0], str[1]);
		}
		
		return jo.toString();
	}
	
	
}
