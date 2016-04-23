package com.oneflyingleaf.core.ho.data;

import java.util.HashSet;
import java.util.Set;


/**
 * Vip entity. @author MyEclipse Persistence Tools
 */

public class Vip  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 4661791872388979654L;
	private String vipId;
     private User user;
     private Boolean level;
     private String vipStat;
     private Set users = new HashSet(0);
     private Set vipTimes = new HashSet(0);


    // Constructors

    /** default constructor */
    public Vip() {
    }

	/** minimal constructor */
    public Vip(String vipId, Boolean level) {
        this.vipId = vipId;
        this.level = level;
    }
    
    /** full constructor */
    public Vip(String vipId, User user, Boolean level, String vipStat, Set users, Set vipTimes) {
        this.vipId = vipId;
        this.user = user;
        this.level = level;
        this.vipStat = vipStat;
        this.users = users;
        this.vipTimes = vipTimes;
    }

   
    // Property accessors

    public String getVipId() {
        return this.vipId;
    }
    
    public void setVipId(String vipId) {
        this.vipId = vipId;
    }

    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getLevel() {
        return this.level;
    }
    
    public void setLevel(Boolean level) {
        this.level = level;
    }

    public String getVipStat() {
        return this.vipStat;
    }
    
    public void setVipStat(String vipStat) {
        this.vipStat = vipStat;
    }

    public Set getUsers() {
        return this.users;
    }
    
    public void setUsers(Set users) {
        this.users = users;
    }

    public Set getVipTimes() {
        return this.vipTimes;
    }
    
    public void setVipTimes(Set vipTimes) {
        this.vipTimes = vipTimes;
    }
   








}