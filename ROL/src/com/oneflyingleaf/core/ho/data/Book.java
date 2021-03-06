package com.oneflyingleaf.core.ho.data;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

import com.oneflyingleaf.crawler.constant.CrawlerConstant;

// default package

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
     private String bookName;
     private String authorId;
     private String bookDes;
     private String bookSize;
     private String bookTextCount;
     private String bookStat;
     private String bookPay;
     private Timestamp bookDate;//最新的更新时间
     private String authName;//作者名
     private String bookImg;
     private String bookType;
     
     private BookChaper bookChaper;
     private List<BookChaper> bookChapers;
     

     
     
    public String getBookId() {
        return this.bookId;
    }
    
    public void setBookId(String bookId) {
        this.bookId = bookId;
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

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public Timestamp getBookDate() {
		return bookDate;
	}

	public void setBookDate(Timestamp bookDate) {
		this.bookDate = bookDate;
	}

	public String getBookImg() {
		if(bookImg == null) return bookImg;
		return CrawlerConstant.BOOK_USE+bookImg.replaceAll(CrawlerConstant.BOOK_IMG2,"" ).replaceAll("\\\\", "/");
	}

	public void setBookImg(String bookImg) {
		this.bookImg = bookImg;
	}
	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public String getBookAtt() {
		return new Random().nextInt(90000)+10000+"";
	}

	public BookChaper getBookChaper() {
		return bookChaper;
	}

	public void setBookChaper(BookChaper bookChaper) {
		this.bookChaper = bookChaper;
	}

	public List<BookChaper> getBookChapers() {
		return bookChapers;
	}

	public void setBookChapers(List<BookChaper> bookChapers) {
		this.bookChapers = bookChapers;
	}




}