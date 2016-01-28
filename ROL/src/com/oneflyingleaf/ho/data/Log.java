package com.oneflyingleaf.ho.data;

// default package

import java.sql.Timestamp;


/**
 * Log entity. @author MyEclipse Persistence Tools
 */

public class Log  implements java.io.Serializable {


    // Fields    

     private String logId;
     private String logCode;
     private String logDes;
     private String logIp;
     private Timestamp createTime;
     private String logType;
     private String userId;


    // Constructors

    /** default constructor */
    public Log() {
    }

	/** minimal constructor */
    public Log(String logId, String logCode, String logDes, Timestamp createTime, String logType) {
        this.logId = logId;
        this.logCode = logCode;
        this.logDes = logDes;
        this.createTime = createTime;
        this.logType = logType;
    }
    
    /** full constructor */
    public Log(String logId, String logCode, String logDes, String logIp, Timestamp createTime, String logType, String userId) {
        this.logId = logId;
        this.logCode = logCode;
        this.logDes = logDes;
        this.logIp = logIp;
        this.createTime = createTime;
        this.logType = logType;
        this.userId = userId;
    }

   
    // Property accessors

    public String getLogId() {
        return this.logId;
    }
    
    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getLogCode() {
        return this.logCode;
    }
    
    public void setLogCode(String logCode) {
        this.logCode = logCode;
    }

    public String getLogDes() {
        return this.logDes;
    }
    
    public void setLogDes(String logDes) {
        this.logDes = logDes;
    }

    public String getLogIp() {
        return this.logIp;
    }
    
    public void setLogIp(String logIp) {
        this.logIp = logIp;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getLogType() {
        return this.logType;
    }
    
    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
   








}