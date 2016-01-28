package com.oneflyingleaf.core.ho.data;

import java.util.HashSet;
import java.util.Set;


/**
 * DynamicHonerDict entity. @author MyEclipse Persistence Tools
 */

public class DynamicHonerDict  implements java.io.Serializable {


    // Fields    

     private String dynHonId;
     private String honCon;
     private Double honWei;
     private String honSta;
     private Set bookDyns = new HashSet(0);


    // Constructors

    /** default constructor */
    public DynamicHonerDict() {
    }

	/** minimal constructor */
    public DynamicHonerDict(String dynHonId, String honCon, Double honWei, String honSta) {
        this.dynHonId = dynHonId;
        this.honCon = honCon;
        this.honWei = honWei;
        this.honSta = honSta;
    }
    
    /** full constructor */
    public DynamicHonerDict(String dynHonId, String honCon, Double honWei, String honSta, Set bookDyns) {
        this.dynHonId = dynHonId;
        this.honCon = honCon;
        this.honWei = honWei;
        this.honSta = honSta;
        this.bookDyns = bookDyns;
    }

   
    // Property accessors

    public String getDynHonId() {
        return this.dynHonId;
    }
    
    public void setDynHonId(String dynHonId) {
        this.dynHonId = dynHonId;
    }

    public String getHonCon() {
        return this.honCon;
    }
    
    public void setHonCon(String honCon) {
        this.honCon = honCon;
    }

    public Double getHonWei() {
        return this.honWei;
    }
    
    public void setHonWei(Double honWei) {
        this.honWei = honWei;
    }

    public String getHonSta() {
        return this.honSta;
    }
    
    public void setHonSta(String honSta) {
        this.honSta = honSta;
    }

    public Set getBookDyns() {
        return this.bookDyns;
    }
    
    public void setBookDyns(Set bookDyns) {
        this.bookDyns = bookDyns;
    }
   








}