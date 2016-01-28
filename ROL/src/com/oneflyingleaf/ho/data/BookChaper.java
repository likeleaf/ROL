package com.oneflyingleaf.ho.data;

// default package



/**
 * BookChaper entity. @author MyEclipse Persistence Tools
 */

public class BookChaper  implements java.io.Serializable {


    // Fields    

     private String bookChaId;
     private BookPart bookPart;
     private String bookPartId;
     private String bookChaCon;
     private Integer bookChaIndex;


    // Constructors

    /** default constructor */
    public BookChaper() {
    }

	/** minimal constructor */
    public BookChaper(String bookChaId, String bookPartId, String bookChaCon, Integer bookChaIndex) {
        this.bookChaId = bookChaId;
        this.bookPartId = bookPartId;
        this.bookChaCon = bookChaCon;
        this.bookChaIndex = bookChaIndex;
    }
    
    /** full constructor */
    public BookChaper(String bookChaId, BookPart bookPart, String bookPartId, String bookChaCon, Integer bookChaIndex) {
        this.bookChaId = bookChaId;
        this.bookPart = bookPart;
        this.bookPartId = bookPartId;
        this.bookChaCon = bookChaCon;
        this.bookChaIndex = bookChaIndex;
    }

   
    // Property accessors

    public String getBookChaId() {
        return this.bookChaId;
    }
    
    public void setBookChaId(String bookChaId) {
        this.bookChaId = bookChaId;
    }

    public BookPart getBookPart() {
        return this.bookPart;
    }
    
    public void setBookPart(BookPart bookPart) {
        this.bookPart = bookPart;
    }

    public String getBookPartId() {
        return this.bookPartId;
    }
    
    public void setBookPartId(String bookPartId) {
        this.bookPartId = bookPartId;
    }

    public String getBookChaCon() {
        return this.bookChaCon;
    }
    
    public void setBookChaCon(String bookChaCon) {
        this.bookChaCon = bookChaCon;
    }

    public Integer getBookChaIndex() {
        return this.bookChaIndex;
    }
    
    public void setBookChaIndex(Integer bookChaIndex) {
        this.bookChaIndex = bookChaIndex;
    }
   








}