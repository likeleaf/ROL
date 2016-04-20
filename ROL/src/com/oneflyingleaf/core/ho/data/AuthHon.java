package com.oneflyingleaf.core.ho.data;

import java.sql.Timestamp;


/**
 * AuthHon entity. @author MyEclipse Persistence Tools
 */

public class AuthHon  implements java.io.Serializable {


    // Fields    

     private String authHonId;
     private Author auther;
     private AuthHonDict authHonDict;
     private String authId;
     private Timestamp createTimr;
     private String authHonDict_1;


    // Constructors

    /** default constructor */
    public AuthHon() {
    }

	/** minimal constructor */
    public AuthHon(String authHonId, String authId, Timestamp createTimr, String authHonDict_1) {
        this.authHonId = authHonId;
        this.authId = authId;
        this.createTimr = createTimr;
        this.authHonDict_1 = authHonDict_1;
    }
    
    /** full constructor */
    public AuthHon(String authHonId, Author auther, AuthHonDict authHonDict, String authId, Timestamp createTimr, String authHonDict_1) {
        this.authHonId = authHonId;
        this.auther = auther;
        this.authHonDict = authHonDict;
        this.authId = authId;
        this.createTimr = createTimr;
        this.authHonDict_1 = authHonDict_1;
    }

   
    // Property accessors

    public String getAuthHonId() {
        return this.authHonId;
    }
    
    public void setAuthHonId(String authHonId) {
        this.authHonId = authHonId;
    }

    public Author getAuther() {
        return this.auther;
    }
    
    public void setAuther(Author auther) {
        this.auther = auther;
    }

    public AuthHonDict getAuthHonDict() {
        return this.authHonDict;
    }
    
    public void setAuthHonDict(AuthHonDict authHonDict) {
        this.authHonDict = authHonDict;
    }

    public String getAuthId() {
        return this.authId;
    }
    
    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public Timestamp getCreateTimr() {
        return this.createTimr;
    }
    
    public void setCreateTimr(Timestamp createTimr) {
        this.createTimr = createTimr;
    }

    public String getAuthHonDict_1() {
        return this.authHonDict_1;
    }
    
    public void setAuthHonDict_1(String authHonDict_1) {
        this.authHonDict_1 = authHonDict_1;
    }
   








}