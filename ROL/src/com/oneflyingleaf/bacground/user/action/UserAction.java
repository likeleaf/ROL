package com.oneflyingleaf.bacground.user.action;


import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import net.sf.json.JSONArray;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import com.oneflyingleaf.bacground.util.DataUtils;
import com.oneflyingleaf.core.action.BasicAction;
import com.oneflyingleaf.core.ho.data.User;

public class UserAction extends BasicAction{
	private User user;


	private static final long serialVersionUID = 9038518566365097307L;
	
	/**
	 * ͨ��ҳ����ÿҳ�������õ�����������û���Ϣ
	 */
	public void getUserJson(){
		String page = this.getParameter("page");
		String rows = this.getParameter("rows");
		int[] range = DataUtils.getPageRange(page, rows);

		JSONArray ja = new JSONArray();
		
		List<User> users = this.basicService.find("from User where rownum <= "+range[1]+" and rownum >="+range[0], null);
		
		for(User u:users){
			ja.add(u);
		}
		this.outPut(ja.toString());
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
			if(this.basicService.find("from User where userName = ? and userId != ?",new Object[]{name,id}).size() == 0){
				this.outPut("suc");
				return ;
			}
			this.outPut("fal");
			return ;
		}
		//������
		if(this.basicService.find("from User where userName = ?",new Object[]{name}).size() == 0){
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
		System.out.println(DigestUtils.md5Hex(userPwCom));
		System.out.println(user.getUserPw());
		
		if(!DigestUtils.md5Hex(userPwCom).equals(user.getUserPw())) {
			this.outPut("{'msg':'����ʧ�ܣ������ȷ�����벻һ�£�'}");
			return ;
		}
		if(!Pattern.matches("^([a-z0-9_.-]+)@([\\da-z.-]+).([a-z.]{2,6})$", user.getEmail())){
			this.outPut("{'msg':'����ʧ�ܣ�email��ʽ����ȷ��'}");
			return;
		}
		
		if(this.basicService.find("from User where email = ?",new Object[]{user.getEmail()}).size() != 0){
			this.outPut("{'msg':'����ʧ�ܣ���email�Ѵ��ڣ�'}");
			return;
		}
		user.setUserName("�û�"+user.getEmail().substring(0, 3));
		
		if(this.basicService.save(user)){
			this.outPut("{'suc':'suc'}");
		}else{
			this.outPut("{'msg':'����ʧ�ܣ�'}");
		}
	}
	
	/**
	 * ɾ����Ӧ�û�
	 */
	public void removeUser(){
		String id = this.getParameter("id");
		if(this.basicService.delete(new User(id))){
			this.outPut("{'success':'suc'}");
		}else{
			this.outPut("{'msg','ɾ��ʧ�ܣ�'}");
		}
	}
	
	
	public void searchUser(){
		String createStart = this.getParameter("createStart");
		String createEnd = this.getParameter("createEnd");
		
		
		
	}
	
	/*********************************************getter/setter*************************************************/
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
