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
	 
	 private Integer vipId;
	 private String userId;
     private Integer level;
     private String vipStat;


    // Constructors

    /** default constructor */
    public Vip() {
    }






    public String getVipStat() {
        return this.vipStat;
    }
    
    public void setVipStat(String vipStat) {
        this.vipStat = vipStat;
    }




	public Integer getVipId() {
		return vipId;
	}



	public void setVipId(Integer vipId) {
		this.vipId = vipId;
	}




	public String getUserId() {
		return userId;
	}




	public void setUserId(String userId) {
		this.userId = userId;
	}






	public Integer getLevel() {
		return level;
	}






	public void setLevel(Integer level) {
		this.level = level;
	}
   








}