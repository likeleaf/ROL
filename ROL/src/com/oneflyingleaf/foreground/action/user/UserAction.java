package com.oneflyingleaf.foreground.action.user;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.regex.Pattern;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;

import com.oneflyingleaf.core.action.BasicAction;
import com.oneflyingleaf.core.constant.SessionEnum;
import com.oneflyingleaf.core.ho.data.User;
import com.oneflyingleaf.core.util.JsonUtils;

/**
 * 前台user
 * @author Administrator
 *
 */
public class UserAction extends BasicAction{

	private static final long serialVersionUID = -6198257252807150588L;
	private final static String NAME = "leaf_";
	private String msg ;

	
	
	public String registUser(){
		String email = this.getParameter("email");
		String password = this.getParameter("password");
		String passwordCheck = this.getParameter("passwordCheck");
		

		if(StringUtils.isBlank(email) || StringUtils.isBlank(password) || StringUtils.isBlank(passwordCheck)){
			
			/*this.outPut(JsonUtils.toJsonString("stat:fal,msg:邮箱，密码，确认密码均不能为空"));*/
		}else if(isExitEmail(email,null ,false)){
			/*this.outPut(JsonUtils.toJsonString("stat:fal,msg:该邮箱已存在"));*/
		}else{
			User u = new User();
			u.setEmail(email);
			u.setUserName(NAME+email.substring(0, 6));
			u.setUserPw(password);
			this.basicService.save(u);
			this.setSessionAttribute(SessionEnum.USER.toString(), u);
			return SUCCESS;
		}
		return ERROR;
	}
	
	/**
	 * 校验email
	 */
	public void checkEmail(){
		String email = this.getParameter("email");
		try {
			email = URLDecoder.decode(email,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		this.isExitEmail(email, null,true);
	}
	
	/**
	 * 验证email有效  （ 这样写感觉不是很好  职责不清，乱）
	 */
	private boolean isExitEmail(String email ,String userId,boolean outPut){
		
		String str = "";
		if(StringUtils.isBlank(email)){
			str = JsonUtils.toJsonString("stat:fal,msg:email不能为空");
		}else if(!Pattern.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", email)){
			str = JsonUtils.toJsonString("stat:fal,msg:email格式不正确");
		}else{
			List<User> lists = null;
			if(StringUtils.isBlank(userId)){
				lists = this.basicService.find("from User where email = ?",new Object[]{email} );
			}else{
				lists = this.basicService.find("from User where email = ? and userId != ?",new Object[]{email,userId} );
			}
			
			if(lists == null || lists.size() == 0){
				str = JsonUtils.toJsonString("stat:suc,msg:该email可以使用");
				if(outPut){
					this.outPut(str);
				}
				return false;
			}
			str = JsonUtils.toJsonString("stat:fal,msg:该email已经存在");
		}	
		
		if(outPut){
			this.outPut(str);
		}
		return true;
	}
	
	
	
	/**
	 * 登录
	 */
	public String login(){
		String email = this.getParameter("email");
		String password = this.getParameter("password");
		
		if(StringUtils.isNotBlank(email)&&StringUtils.isNotBlank(password)){
			password = org.apache.commons.codec.digest.DigestUtils.md5Hex(password);
			User user =  this.basicService.findOne("from User u where u.email = ? and u.userPw =?",new Object[]{email,password});
			if(user != null){
				this.setSessionAttribute(SessionEnum.USER.toString(), user);
				return SUCCESS;
			}
		}
		
		
		return ERROR;
	}
	
	
	
	public String logout(){
 		this.deleteSession();
		return SUCCESS;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
