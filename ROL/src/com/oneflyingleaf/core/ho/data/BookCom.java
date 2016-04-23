package com.oneflyingleaf.core.ho.data;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * BookCom entity. @author MyEclipse Persistence Tools
 */

public class BookCom  implements java.io.Serializable {


    // Fields    

     private String bookComId;
     private String bookId;
     private Timestamp createTime;
     private String comCon;
     private String comFrom;
     private String comTo;
     private Set books = new HashSet(0);


    // Constructors

    /** default constructor */
    public BookCom() {
    }

	/** minimal constructor */
    public BookCom(String bookComId, String bookId, Timestamp createTime, String comCon, String comFrom, String comTo) {
        this.bookComId = bookComId;
        this.bookId = bookId;
        this.createTime = createTime;
        this.comCon = comCon;
        this.comFrom = comFrom;
        this.comTo = comTo;
    }
    
    /** full constructor */
    public BookCom(String bookComId, String bookId, Timestamp createTime, String comCon, String comFrom, String comTo, Set books) {
        this.bookComId = bookComId;
        this.bookId = bookId;
        this.createTime = createTime;
        this.comCon = comCon;
        this.comFrom = comFrom;
        this.comTo = comTo;
        this.books = books;
    }

   
    // Property accessors

    public String getBookComId() {
        return this.bookComId;
    }
    
    public void setBookComId(String bookComId) {
        this.bookComId = bookComId;
    }

    public String getBookId() {
        return this.bookId;
    }
    
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getComCon() {
        return this.comCon;
    }
    
    public void setComCon(String comCon) {
        this.comCon = comCon;
    }

    public String getComFrom() {
        return this.comFrom;
    }
    
    public void setComFrom(String comFrom) {
        this.comFrom = comFrom;
    }

    public String getComTo() {
        return this.comTo;
    }
    
    public void setComTo(String comTo) {
        this.comTo = comTo;
    }

    public Set getBooks() {
        return this.books;
    }
    
    public void setBooks(Set books) {
        this.books = books;
    }
   








}