package com.oneflyingleaf.core.ho.data;

// default package

import java.util.HashSet;
import java.util.Set;


/**
 * Book entity. @author MyEclipse Persistence Tools
 */

public class Book  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 3123477705550299118L;
	private String bookId;
     private Author auther;
     private BookCom bookCom;
     private String bookName;
     private String authorId;
     private String bookDes;
     private String bookSize;
     private String bookTextCount;
     private String bookStat;
     private String bookPay;
     private Set honors = new HashSet(0);
     private Set bookParts = new HashSet(0);
     private Set bookDyns = new HashSet(0);


    // Constructors

    /** default constructor */
    public Book() {
    }

	/** minimal constructor */
    public Book(String bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }
    
    /** full constructor */
    public Book(String bookId, Author auther, BookCom bookCom, String bookName, String authorId, String bookDes, String bookSize, String bookTextCount, String bookStat, String bookPay, Set honors, Set bookParts, Set bookDyns) {
        this.bookId = bookId;
        this.auther = auther;
        this.bookCom = bookCom;
        this.bookName = bookName;
        this.authorId = authorId;
        this.bookDes = bookDes;
        this.bookSize = bookSize;
        this.bookTextCount = bookTextCount;
        this.bookStat = bookStat;
        this.bookPay = bookPay;
        this.honors = honors;
        this.bookParts = bookParts;
        this.bookDyns = bookDyns;
    }

   
    // Property accessors

    public String getBookId() {
        return this.bookId;
    }
    
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Author getAuther() {
        return this.auther;
    }
    
    public void setAuther(Author auther) {
        this.auther = auther;
    }

    public BookCom getBookCom() {
        return this.bookCom;
    }
    
    public void setBookCom(BookCom bookCom) {
        this.bookCom = bookCom;
    }

    public String getBookName() {
        return this.bookName;
    }
    
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorId() {
        return this.authorId;
    }
    
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getBookDes() {
        return this.bookDes;
    }
    
    public void setBookDes(String bookDes) {
        this.bookDes = bookDes;
    }

    public String getBookSize() {
        return this.bookSize;
    }
    
    public void setBookSize(String bookSize) {
        this.bookSize = bookSize;
    }

    public String getBookTextCount() {
        return this.bookTextCount;
    }
    
    public void setBookTextCount(String bookTextCount) {
        this.bookTextCount = bookTextCount;
    }

    public String getBookStat() {
        return this.bookStat;
    }
    
    public void setBookStat(String bookStat) {
        this.bookStat = bookStat;
    }

    public String getBookPay() {
        return this.bookPay;
    }
    
    public void setBookPay(String bookPay) {
        this.bookPay = bookPay;
    }

    public Set getHonors() {
        return this.honors;
    }
    
    public void setHonors(Set honors) {
        this.honors = honors;
    }

    public Set getBookParts() {
        return this.bookParts;
    }
    
    public void setBookParts(Set bookParts) {
        this.bookParts = bookParts;
    }

    public Set getBookDyns() {
        return this.bookDyns;
    }
    
    public void setBookDyns(Set bookDyns) {
        this.bookDyns = bookDyns;
    }
   








}