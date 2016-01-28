package com.oneflyingleaf.ho.data;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * Auther entity. @author MyEclipse Persistence Tools
 */

public class Author  implements java.io.Serializable {


    // Fields    

     private String autId;
     private User user;
     private Timestamp craeteTime;


    // Constructors

    /** default constructor */
    public Author() {
    }

	/** minimal constructor */
    public Author(String autId, Timestamp craeteTime) {
        this.autId = autId;
        this.craeteTime = craeteTime;
    }
    
    /** full constructor */
    public Author(String autId, User user, Timestamp craeteTime, Set users, Set authHons, Set books) {
        this.autId = autId;
        this.user = user;
        this.craeteTime = craeteTime;
    }

   
    // Property accessors

    public String getAutId() {
        return this.autId;
    }
    
    public void setAutId(String autId) {
        this.autId = autId;
    }

    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getCraeteTime() {
        return this.craeteTime;
    }
    
    public void setCraeteTime(Timestamp craeteTime) {
        this.craeteTime = craeteTime;
    }


}