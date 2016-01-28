package com.oneflyingleaf.ho.data;

// default package

import java.util.HashSet;
import java.util.Set;


/**
 * BookPart entity. @author MyEclipse Persistence Tools
 */

public class BookPart  implements java.io.Serializable {


    // Fields    

     private String bookPartId;
     private Book book;
     private String bookId;
     private String bookPartTitle;
     private String bookPartIndex;
     private String bookPartStat;
     private Set bookChapers = new HashSet(0);


    // Constructors

    /** default constructor */
    public BookPart() {
    }

	/** minimal constructor */
    public BookPart(String bookPartId, String bookId, String bookPartTitle, String bookPartIndex, String bookPartStat) {
        this.bookPartId = bookPartId;
        this.bookId = bookId;
        this.bookPartTitle = bookPartTitle;
        this.bookPartIndex = bookPartIndex;
        this.bookPartStat = bookPartStat;
    }
    
    /** full constructor */
    public BookPart(String bookPartId, Book book, String bookId, String bookPartTitle, String bookPartIndex, String bookPartStat, Set bookChapers) {
        this.bookPartId = bookPartId;
        this.book = book;
        this.bookId = bookId;
        this.bookPartTitle = bookPartTitle;
        this.bookPartIndex = bookPartIndex;
        this.bookPartStat = bookPartStat;
        this.bookChapers = bookChapers;
    }

   
    // Property accessors

    public String getBookPartId() {
        return this.bookPartId;
    }
    
    public void setBookPartId(String bookPartId) {
        this.bookPartId = bookPartId;
    }

    public Book getBook() {
        return this.book;
    }
    
    public void setBook(Book book) {
        this.book = book;
    }

    public String getBookId() {
        return this.bookId;
    }
    
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookPartTitle() {
        return this.bookPartTitle;
    }
    
    public void setBookPartTitle(String bookPartTitle) {
        this.bookPartTitle = bookPartTitle;
    }

    public String getBookPartIndex() {
        return this.bookPartIndex;
    }
    
    public void setBookPartIndex(String bookPartIndex) {
        this.bookPartIndex = bookPartIndex;
    }

    public String getBookPartStat() {
        return this.bookPartStat;
    }
    
    public void setBookPartStat(String bookPartStat) {
        this.bookPartStat = bookPartStat;
    }

    public Set getBookChapers() {
        return this.bookChapers;
    }
    
    public void setBookChapers(Set bookChapers) {
        this.bookChapers = bookChapers;
    }
   








}