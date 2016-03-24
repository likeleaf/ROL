package com.oneflyingleaf.core.ho.data;

// default package

import java.sql.Timestamp;
import java.util.Date;



/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User  implements java.io.Serializable {

	

    // Fields    

  

	/**
	 * 
	 */
	private static final long serialVersionUID = 5074727592887383184L;
	
	//对应权限  10：普通用户  20：作者   30：vip   40：管理员：50   超级管理员
	public static final String USER_NOR = "10";
	public static final String USER_AUTHOR = "20";
	public static final String USER_VIP = "30";
	public static final String USER_MANAGER = "40";
	public static final String USER_SUPER_MANAGER = "50";
	
	/*public static final String 普通用户 = "10";
	public static final String 作者 = "20";
	public static final String USER_VIP = "30";
	public static final String 管理员 = "40";
	public static final String 超级管理员 = "50";*/
	
	
	 private String userId;
     private Author auther;
     private Vip vip;
     private String userName;
     private String userPw;
     private String email;
     private String qq;
     private String adress;
     private String phone;
     private Timestamp createTime = new Timestamp(System.currentTimeMillis());
//   private String createTimeForShow;
     private String gender;
     private Short age;
     private String permission = "10";
     private String userState = "10";


    // Constructors

    public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	/** default constructor */
    public User() {
    }
    
    //for delete
    public User(String userId) {
    	this.userId = userId;
    }

	/** minimal constructor */
    public User(String userId, String userName, String userPw, String email, Timestamp createTime, String permission) {
        this.userId = userId;
        this.userName = userName;
        this.userPw = userPw;
        this.email = email;
        this.createTime = createTime;
        this.permission = permission;
    }
    
    /** full constructor */
    public User(String userId, Author auther, Vip vip, String userName, String userPw, String email, String qq, String adress, String phone, Timestamp createTime, String gender, Short age, String permission) {
        this.userId = userId;
        this.auther = auther;
        this.vip = vip;
        this.userName = userName;
        this.userPw = userPw;
        this.email = email;
        this.qq = qq;
        this.adress = adress;
        this.phone = phone;
        this.createTime = createTime;
        this.gender = gender;
        this.age = age;
        this.permission = permission;
    }

   
    // Property accessors

    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Author getAuthor() {
        return this.auther;
    }
    
    public void setAuthor(Author author) {
        this.auther = author;
    }

    public Vip getVip() {
        return this.vip;
    }
    
    public void setVip(Vip vip) {
        this.vip = vip;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPw() {
        return this.userPw;
    }
    
    public void setUserPw(String userPw) {
    	this.userPw = org.apache.commons.codec.digest.DigestUtils.md5Hex(userPw);
    }

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return this.qq;
    }
    
    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getAdress() {
        return this.adress;
    }
    
    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }
    
	public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }

    public Short getAge() {
        return this.age;
    }
    
    public void setAge(Short age) {
        this.age = age;
    }

    public String getPermission() {
        return this.permission;
    }
    
    public void setPermission(String permission) {
        this.permission = permission;
    }

 /*   public String getCreateTimeForShow() {
    	Timestamp ts = getCreateTime();
    	return DateUtils.formatDate(ts, "yyyy-MM-dd");
	}*/
    @Override
 	public String toString() {
 		return "User [userId=" + userId + ", auther=" + auther + ", vip=" + vip
 				+ ", userName=" + userName + ", userPw=" + userPw + ", email="
 				+ email + ", qq=" + qq + ", adress=" + adress + ", phone="
 				+ phone + ", createTime=" + createTime + ", gender=" + gender
 				+ ", age=" + age + ", permission=" + permission
 				+ ", userState=" + userState + "]";
 	}
}