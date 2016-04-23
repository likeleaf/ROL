package com.oneflyingleaf.core.ho.data;

import java.util.HashSet;
import java.util.Set;


/**
 * AuthHonDict entity. @author MyEclipse Persistence Tools
 */

public class AuthHonDict  implements java.io.Serializable {


    // Fields    

     private String authHonId;
     private String authHonDesc;
     private Double authHonWei;
     private Set authHons = new HashSet(0);


    // Constructors

    /** default constructor */
    public AuthHonDict() {
    }

	/** minimal constructor */
    public AuthHonDict(String authHonId, String authHonDesc, Double authHonWei) {
        this.authHonId = authHonId;
        this.authHonDesc = authHonDesc;
        this.authHonWei = authHonWei;
    }
    
    /** full constructor */
    public AuthHonDict(String authHonId, String authHonDesc, Double authHonWei, Set authHons) {
        this.authHonId = authHonId;
        this.authHonDesc = authHonDesc;
        this.authHonWei = authHonWei;
        this.authHons = authHons;
    }

   
    // Property accessors

    public String getAuthHonId() {
        return this.authHonId;
    }
    
    public void setAuthHonId(String authHonId) {
        this.authHonId = authHonId;
    }

    public String getAuthHonDesc() {
        return this.authHonDesc;
    }
    
    public void setAuthHonDesc(String authHonDesc) {
        this.authHonDesc = authHonDesc;
    }

    public Double getAuthHonWei() {
        return this.authHonWei;
    }
    
    public void setAuthHonWei(Double authHonWei) {
        this.authHonWei = authHonWei;
    }

    public Set getAuthHons() {
        return this.authHons;
    }
    
    public void setAuthHons(Set authHons) {
        this.authHons = authHons;
    }
   








}