package com.oneflyingleaf.core.ho.data;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * Auther entity. @author MyEclipse Persistence Tools
 */

public class Author  implements java.io.Serializable {


    // Fields    

	private static final long serialVersionUID = 6891246743780914247L;
	private String autId;
    private User user;
    private Timestamp craeteTime;
    private String authState; 

	/** default constructor */
    public Author() {
    }

	/** minimal constructor */
    public Author(String autId, Timestamp craeteTime) {
        this.autId = autId;
        this.craeteTime = craeteTime;
    }
    
    /** full constructor */
    public Author(String autId, User user, Timestamp craeteTime) {
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

    // Constructors

    public String getAuthState() {
		return authState;
	}

	public void setAuthState(String authState) {
		this.authState = authState;
	}
}