package com.oneflyingleaf.core.ho.data;

import java.sql.Timestamp;


/**
 * UserHis entity. @author MyEclipse Persistence Tools
 */

public class UserHis  implements java.io.Serializable {


    // Fields    

     private String userHisId;
     private UserFav userFav;
     private String bookId;
     private String bookName;
     private String indexId;
     private Timestamp createTime;


    // Constructors

    /** default constructor */
    public UserHis() {
    }

	/** minimal constructor */
    public UserHis(String userHisId, String bookId, String bookName, String indexId, Timestamp createTime) {
        this.userHisId = userHisId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.indexId = indexId;
        this.createTime = createTime;
    }
    
    /** full constructor */
    public UserHis(String userHisId, UserFav userFav, String bookId, String bookName, String indexId, Timestamp createTime) {
        this.userHisId = userHisId;
        this.userFav = userFav;
        this.bookId = bookId;
        this.bookName = bookName;
        this.indexId = indexId;
        this.createTime = createTime;
    }

   
    // Property accessors

    public String getUserHisId() {
        return this.userHisId;
    }
    
    public void setUserHisId(String userHisId) {
        this.userHisId = userHisId;
    }

    public UserFav getUserFav() {
        return this.userFav;
    }
    
    public void setUserFav(UserFav userFav) {
        this.userFav = userFav;
    }

    public String getBookId() {
        return this.bookId;
    }
    
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return this.bookName;
    }
    
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getIndexId() {
        return this.indexId;
    }
    
    public void setIndexId(String indexId) {
        this.indexId = indexId;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
   








}