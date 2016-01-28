package com.oneflyingleaf.ho.data;

// default package

import java.util.HashSet;
import java.util.Set;


/**
 * UserFav entity. @author MyEclipse Persistence Tools
 */

public class UserFav  implements java.io.Serializable {


    // Fields    

     private String userFavId;
     private User user;
     private String userId;
     private String font;
     private String fontSize;
     private String fontStyle;
     private String image;
     private String hobbyStat;
     private String backgroumd;
     private Set userHises = new HashSet(0);


    // Constructors

    /** default constructor */
    public UserFav() {
    }

	/** minimal constructor */
    public UserFav(String userFavId, String userId) {
        this.userFavId = userFavId;
        this.userId = userId;
    }
    
    /** full constructor */
    public UserFav(String userFavId, User user, String userId, String font, String fontSize, String fontStyle, String image, String hobbyStat, String backgroumd, Set userHises) {
        this.userFavId = userFavId;
        this.user = user;
        this.userId = userId;
        this.font = font;
        this.fontSize = fontSize;
        this.fontStyle = fontStyle;
        this.image = image;
        this.hobbyStat = hobbyStat;
        this.backgroumd = backgroumd;
        this.userHises = userHises;
    }

   
    // Property accessors

    public String getUserFavId() {
        return this.userFavId;
    }
    
    public void setUserFavId(String userFavId) {
        this.userFavId = userFavId;
    }

    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFont() {
        return this.font;
    }
    
    public void setFont(String font) {
        this.font = font;
    }

    public String getFontSize() {
        return this.fontSize;
    }
    
    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    public String getFontStyle() {
        return this.fontStyle;
    }
    
    public void setFontStyle(String fontStyle) {
        this.fontStyle = fontStyle;
    }

    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }

    public String getHobbyStat() {
        return this.hobbyStat;
    }
    
    public void setHobbyStat(String hobbyStat) {
        this.hobbyStat = hobbyStat;
    }

    public String getBackgroumd() {
        return this.backgroumd;
    }
    
    public void setBackgroumd(String backgroumd) {
        this.backgroumd = backgroumd;
    }

    public Set getUserHises() {
        return this.userHises;
    }
    
    public void setUserHises(Set userHises) {
        this.userHises = userHises;
    }
   








}