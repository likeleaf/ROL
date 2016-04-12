package com.oneflyingleaf.core.ho.data;

// default package



/**
 * BookChaper entity. @author MyEclipse Persistence Tools
 */

public class BookChaper  implements java.io.Serializable {


    // Fields    

     private String bookChaId;
     private String bookPartId;
     private String bookChaCon;
     private Integer bookChaIndex;
     private String bookChaTitle;
     private String bookId;



   
    // Property accessors

    public String getBookChaId() {
        return this.bookChaId;
    }
    
    public void setBookChaId(String bookChaId) {
        this.bookChaId = bookChaId;
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

	public String getBookChaTitle() {
		return bookChaTitle;
	}

	public void setBookChaTitle(String bookChaTitle) {
		this.bookChaTitle = bookChaTitle;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
   








}