package com.oneflyingleaf.background.core.util;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.oneflyingleaf.core.util.SpringUtils;
import com.oneflyingleaf.core.util.helper.QueryHelper;

public class GridUtils {
	
	
	/**
	 * �õ���Ӧ��qh��ѯֵ��json��Ĭ��ֻ��ѯ��Ӧrownum������
	 * @param req ��Ҫ����rownum ���������洫�� rows��pages
	 * @param qh
	 * @return
	 */
	public static String getJson(HttpServletRequest req,QueryHelper qh){
		Serializable total = SpringUtils.getBaseService().findOne("select count(*) " + qh.getHQL(), qh.getValue());
		String page = req.getParameter("page");
		String rows = req.getParameter("rows");
		int[] pageAndRows = DataUtils.getPageAndRows(page, rows);

		JSONArray ja = new JSONArray();
		
		long c = System.currentTimeMillis();
		List<?> t = SpringUtils.getBaseService().padingFind(qh.getHQL(), qh.getValue(),pageAndRows[1],pageAndRows[0]);
		
//		List<?> t = SpringUtils.getBaseService().find(qh.getHQL(), qh.getValue());
		
		System.out.println(System.currentTimeMillis() - c);
		
		
		for(Object u:t){
			ja.add(u);
		}
		JSONObject jo = new JSONObject();
		
		jo.put("total", total);
		jo.put("rows", ja.toString());
		return jo.toString();
	}
}
