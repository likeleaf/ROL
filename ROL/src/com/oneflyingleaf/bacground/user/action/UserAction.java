package com.oneflyingleaf.bacground.user.action;


import java.util.List;

import net.sf.json.JSONArray;

import com.oneflyingleaf.bacground.util.DataUtils;
import com.oneflyingleaf.core.action.BasicAction;
import com.oneflyingleaf.core.ho.data.User;

public class UserAction extends BasicAction{

	private static final long serialVersionUID = 9038518566365097307L;
	
	public void getUserJson(){
		String page = this.getParameter("page");
		String rows = this.getParameter("rows");
		int[] range = DataUtils.getPageRange(page, rows);

		JSONArray ja = new JSONArray();
		
		List<User> users = this.basicService.find("from User where rownums <= "+range[1]+" and rownums >="+range[0], null);
		
		for(User u:users){
			ja.add(u);
		}
		this.outPut(ja.toString());
	}

}
