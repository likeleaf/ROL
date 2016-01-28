package com.oneflyingleaf.core.ho.data;

// default package

import java.sql.Timestamp;


/**
 * BookDyn entity. @author MyEclipse Persistence Tools
 */

public class BookDyn  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = -236717005828283796L;
	private String bookDynId;
     private Book book;
     private DynamicHonerDict dynamicHonerDict;
     private String bookId;
     private String dynHonId;
     private Timestamp honDate;


    // Constructors

    /** default constructor */
    public BookDyn() {
    }

	/** minimal constructor */
    public BookDyn(String bookDynId, String bookId, String dynHonId, Timestamp honDate) {
        this.bookDynId = bookDynId;
        this.bookId = bookId;
        this.dynHonId = dynHonId;
        this.honDate = honDate;
    }
    
    /** full constructor */
    public BookDyn(String bookDynId, Book book, DynamicHonerDict dynamicHonerDict, String bookId, String dynHonId, Timestamp honDate) {
        this.bookDynId = bookDynId;
        this.book = book;
        this.dynamicHonerDict = dynamicHonerDict;
        this.bookId = bookId;
        this.dynHonId = dynHonId;
        this.honDate = honDate;
    }

   
    // Property accessors

    public String getBookDynId() {
        return this.bookDynId;
    }
    
    public void setBookDynId(String bookDynId) {
        this.bookDynId = bookDynId;
    }

    public Book getBook() {
        return this.book;
    }
    
    public void setBook(Book book) {
        this.book = book;
    }

    public DynamicHonerDict getDynamicHonerDict() {
        return this.dynamicHonerDict;
    }
    
    public void setDynamicHonerDict(DynamicHonerDict dynamicHonerDict) {
        this.dynamicHonerDict = dynamicHonerDict;
    }

    public String getBookId() {
        return this.bookId;
    }
    
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getDynHonId() {
        return this.dynHonId;
    }
    
    public void setDynHonId(String dynHonId) {
        this.dynHonId = dynHonId;
    }

    public Timestamp getHonDate() {
        return this.honDate;
    }
    
    public void setHonDate(Timestamp honDate) {
        this.honDate = honDate;
    }
   








}