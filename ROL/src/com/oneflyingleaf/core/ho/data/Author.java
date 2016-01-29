package com.oneflyingleaf.core.ho.data;

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
     Set users =  new HashSet();

	Set authHons = new HashSet();
     Set books = new HashSet();

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
        this.users = users;
        this.authHons = authHons;
        this.books = books;
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


    public Set getUsers() {
    	return users;
    }
    
    public void setUsers(Set users) {
    	this.users = users;
    }
    
    public Set getAuthHons() {
    	return authHons;
    }
    
    public void setAuthHons(Set authHons) {
    	this.authHons = authHons;
    }
    
    public Set getBooks() {
    	return books;
    }
    
    public void setBooks(Set books) {
    	this.books = books;
    }
}