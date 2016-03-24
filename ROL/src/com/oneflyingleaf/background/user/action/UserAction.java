package com.oneflyingleaf.background.user.action;


import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import com.oneflyingleaf.background.core.util.GridUtils;
import com.oneflyingleaf.background.user.service.UserService;
import com.oneflyingleaf.core.action.BasicAction;
import com.oneflyingleaf.core.constant.PermissionCon;
import com.oneflyingleaf.core.ho.data.User;
import com.oneflyingleaf.core.util.PermissionUtils;
import com.oneflyingleaf.core.util.helper.HelperFactory;
import com.oneflyingleaf.core.util.helper.QueryHelper;


public class UserAction extends BasicAction{
	
	@Resource(name="userService")
	private UserService userService;
	private User user;


	private static final long serialVersionUID = 9038518566365097307L;
	
	/**
	 * ͨ��ҳ����ÿҳ�������õ�����������û���Ϣ
	 */
	public void getUserJson(){
		
		QueryHelper qh = HelperFactory.createQueryHelper(User.class, "u");
		
		qh.addCondition("u.userState = ?", "10");
		qh.addOrderBy("u.createTime", "desc");
		
		this.outPut(GridUtils.getJson(this.getRequest(), qh));
	}
	
	/**
	 * ǰ̨ajaxУ���û�����Ψһ��,������޸�,�Ϸ�Ϊsuc�����Ϸ�Ϊfal���������ִ���Ϊerr
	 */
	public void checkName(){
		String name = this.getParameter("userName");
		//Ĭ��Ϊ����
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
			//������
			if(userService.find("from User where userName = ? and userId != ?",new Object[]{name,id}).size() == 0){
				this.outPut("suc");
				return ;
			}
			this.outPut("fal");
			return ;
		}
		//������
		if(userService.find("from User where userName = ?",new Object[]{name}).size() == 0){
			this.outPut("suc");
			return;
		}
		this.outPut("fal");
		return;
	}
	
	
	
	
	/**
	 * У���Լ������û�����ص���Ϣ
	 */
	public void saveUser(){
		String userPwCom = this.getParameter("userPwCom");
		
		if(StringUtils.isBlank(userPwCom)) {
			this.outPut("{'msg':'����ʧ�ܣ�����ȷ��Ϊ�գ�'}");
			return ;
		}
		
		if(!DigestUtils.md5Hex(userPwCom).equals(user.getUserPw())) {
			this.outPut("{'msg':'����ʧ�ܣ������ȷ�����벻һ�£�'}");
			return ;
		}
		if(!Pattern.matches("^([a-z0-9_.-]+)@([\\da-z.-]+).([a-z.]{2,6})$", user.getEmail())){
			this.outPut("{'msg':'����ʧ�ܣ�email��ʽ����ȷ��'}");
			return;
		}
		
		if(userService.find("from User where email = ?",new Object[]{user.getEmail()}).size() != 0){
			this.outPut("{'msg':'����ʧ�ܣ���email�Ѵ��ڣ�'}");
			return;
		}
		user.setUserName("�û�"+user.getEmail().substring(0, 3));
		
		if(userService.save(user)){
			this.outPut("{'suc':'suc'}");
		}else{
			this.outPut("{'msg':'����ʧ�ܣ�'}");
		}
	}

	/**
	 * �����û�
	 */
	public void searchUser(){
		String createStart = this.getParameter("createStart");
		String createEnd = this.getParameter("createEnd");
		
		QueryHelper qh = HelperFactory.createQueryHelper(User.class, "u");
		qh.addCondition("u.userName like ?", "%"+(StringUtils.isNotBlank(user.getUserName())?user.getUserName():"")+"%");
		qh.addCondition("u.email like ?", "%"+(StringUtils.isNotBlank(user.getEmail())?user.getEmail():"")+"%");
		qh.addCondition("to_char(u.createTime,'yyyy-MM-dd') >= ?", createStart,true);
		qh.addCondition("to_char(u.createTime,'yyyy-MM-dd') >= ?", createEnd, true);
		qh.addCondition("u.permission like ? ", "%"+(StringUtils.isNotBlank(user.getPermission())?user.getPermission():"")+"%",true);
		qh.addCondition("u.userState = ?", "10");
		
		qh.addOrderBy("u.createTime", "desc");
		
		this.outPut(GridUtils.getJson(this.getRequest(), qh));
		
	}
	
	/**
	 * ɾ����ص��û�
	 */
	public void deleteUser(){
		String id = this.getParameter("userId");
		
		if(PermissionUtils.hasPermission(this.getSession(), PermissionCon.DELETE_USER_LOGISTIC)){
			if(userService.deleteUserLogistic(id)){
				this.outPut("{msg:'suc'}");
			}else{
				this.outPut("{msg:'fal'}");
			}
		}else{
			this.outPut("{msg:'noPermission'}");
		}
		
		
	}
	
	/**
	 * �����û���Ϣ
	 */
	public void updateUser(){
		if(StringUtils.isBlank(user.getUserName())){
			this.outPut("{msg:'�û�������Ϊ��'}");
			return ;
		}
		
		if(!Pattern.matches("^([a-z0-9_.-]+)@([\\da-z.-]+).([a-z.]{2,6})$", user.getEmail())){
			this.outPut("{'msg':'����ʧ�ܣ�email��ʽ����ȷ��'}");
			return;
		}
		
		if(userService.find("from User where email = ? and userId != ?",new Object[]{user.getEmail(),user.getUserId()}).size() != 0){
			this.outPut("{'msg':'����ʧ�ܣ���email�Ѵ��ڣ�'}");
			return;
		}
		
		if(PermissionUtils.hasPermission(this.getSession(), PermissionCon.UPDATE_USER_WITH_NO_PERMISSION)){
			if(StringUtils.isBlank(user.getUserId())){
				this.outPut("{msg:'����������ˢ�����ԣ�'}");
				return;
			}
			
			User u = userService.get(User.class, user.getUserId());
			
			if(u == null){
				this.outPut("{msg:'�����ѱ�ɾ������ˢ�����ԣ�'}");
				return;
			}

			if(!PermissionUtils.hasPermission(this.getSession(), PermissionCon.UPDATE_USER_WITH_PERMISSION)){
				if(!u.getPermission().equals(user.getPermission())){
					this.outPut("{msg:'noPermission'}");
					return;
				}
			}
			
			u.setUserName(user.getUserName());
			u.setQq(user.getQq());
			u.setPermission(user.getPermission());
			u.setEmail(user.getEmail());
			
			if(userService.save(u)){
				this.outPut("{msg:suc}");
			}
		}
		
		
	}
	
	/*********************************************getter/setter*************************************************/
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
