package com.oneflyingleaf.bacground.user.action;


import java.util.regex.Pattern;


import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import com.oneflyingleaf.bacground.core.util.GridUtils;
import com.oneflyingleaf.core.action.BasicAction;
import com.oneflyingleaf.core.ho.data.User;
import com.oneflyingleaf.core.util.helper.HelperFactory;
import com.oneflyingleaf.core.util.helper.QueryHelper;


public class UserAction extends BasicAction{
	private User user;


	private static final long serialVersionUID = 9038518566365097307L;
	
	/**
	 * 通过页数和每页的数量得到相关数量的用户信息
	 */
	public void getUserJson(){
		
		QueryHelper qh = HelperFactory.createQueryHelper(User.class, "u");
		
		this.outPut(GridUtils.getJson(this.getRequest(), qh));
	}
	
	/**
	 * 前台ajax校验用户名的唯一性,插入和修改,合法为suc，不合法为fal，参数出现错误为err
	 */
	public void checkName(){
		String name = this.getParameter("userName");
		//默认为插入
		String type = this.getParameter("type");
		if(StringUtils.isBlank(name)){
			this.outPut("err");
		}
		
		if("update".equals(type)){
			String id = this.getParameter("userId");
			if(StringUtils.isBlank(id)){
				this.outPut("err");
				return ;
			}
			//不存在
			if(this.basicService.find("from User where userName = ? and userId != ?",new Object[]{name,id}).size() == 0){
				this.outPut("suc");
				return ;
			}
			this.outPut("fal");
			return ;
		}
		//不存在
		if(this.basicService.find("from User where userName = ?",new Object[]{name}).size() == 0){
			this.outPut("suc");
			return;
		}
		this.outPut("fal");
		return;
	}
	
	
	
	
	/**
	 * 校验以及保存用户的相关的信息
	 */
	public void saveUser(){
		String userPwCom = this.getParameter("userPwCom");
		
		if(StringUtils.isBlank(userPwCom)) {
			this.outPut("{'msg':'保存失败！密码确认为空！'}");
			return ;
		}
		System.out.println(DigestUtils.md5Hex(userPwCom));
		System.out.println(user.getUserPw());
		
		if(!DigestUtils.md5Hex(userPwCom).equals(user.getUserPw())) {
			this.outPut("{'msg':'保存失败！密码和确认密码不一致！'}");
			return ;
		}
		if(!Pattern.matches("^([a-z0-9_.-]+)@([\\da-z.-]+).([a-z.]{2,6})$", user.getEmail())){
			this.outPut("{'msg':'保存失败！email格式不正确！'}");
			return;
		}
		
		if(this.basicService.find("from User where email = ?",new Object[]{user.getEmail()}).size() != 0){
			this.outPut("{'msg':'保存失败，该email已存在！'}");
			return;
		}
		user.setUserName("用户"+user.getEmail().substring(0, 3));
		
		if(this.basicService.save(user)){
			this.outPut("{'suc':'suc'}");
		}else{
			this.outPut("{'msg':'保存失败！'}");
		}
	}
	
	/**
	 * 删除对应用户
	 */
	public void removeUser(){
		String id = this.getParameter("id");
		if(this.basicService.delete(new User(id))){
			this.outPut("{'success':'suc'}");
		}else{
			this.outPut("{'msg','删除失败！'}");
		}
	}
	
	
	public void searchUser(){
		String createStart = this.getParameter("createStart");
		String createEnd = this.getParameter("createEnd");
		
		QueryHelper qh = HelperFactory.createQueryHelper(User.class, "u");
		qh.addCondition("u.userName like ?", "%"+(StringUtils.isNotBlank(user.getUserName())?user.getUserName():"")+"%");
		qh.addCondition("u.email like ?", "%"+(StringUtils.isNotBlank(user.getEmail())?user.getEmail():"")+"%");
		qh.addCondition("to_char(u.createTime,'yyyy-MM-dd') >= ?", createStart,true);
		qh.addCondition("to_char(u.createTime,'yyyy-MM-dd') >= ?", createEnd, true);
		qh.addCondition("u.permission like ? ", "%"+(StringUtils.isNotBlank(user.getPermission())?user.getPermission():"")+"%",true);
		
		qh.addOrderBy("u.createTime", "desc");
		
		this.outPut(GridUtils.getJson(this.getRequest(), qh));
		
	}
	
	/*********************************************getter/setter*************************************************/
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
