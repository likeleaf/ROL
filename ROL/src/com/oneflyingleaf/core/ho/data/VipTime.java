package com.oneflyingleaf.core.ho.data;
// default package

import java.sql.Timestamp;


/**
 * VipTime entity. @author MyEclipse Persistence Tools
 */

public class VipTime  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = -5631717262009185248L;
	private String vipTimeId;
     private Vip vip;
     private String vipId;
     private Timestamp createTime;
     private Timestamp endTime;


    // Constructors

    /** default constructor */
    public VipTime() {
    }

	/** minimal constructor */
    public VipTime(String vipTimeId, String vipId, Timestamp createTime, Timestamp endTime) {
        this.vipTimeId = vipTimeId;
        this.vipId = vipId;
        this.createTime = createTime;
        this.endTime = endTime;
    }
    
    /** full constructor */
    public VipTime(String vipTimeId, Vip vip, String vipId, Timestamp createTime, Timestamp endTime) {
        this.vipTimeId = vipTimeId;
        this.vip = vip;
        this.vipId = vipId;
        this.createTime = createTime;
        this.endTime = endTime;
    }

   
    // Property accessors

    public String getVipTimeId() {
        return this.vipTimeId;
    }
    
    public void setVipTimeId(String vipTimeId) {
        this.vipTimeId = vipTimeId;
    }

    public Vip getVip() {
        return this.vip;
    }
    
    public void setVip(Vip vip) {
        this.vip = vip;
    }

    public String getVipId() {
        return this.vipId;
    }
    
    public void setVipId(String vipId) {
        this.vipId = vipId;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getEndTime() {
        return this.endTime;
    }
    
    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }
   








}