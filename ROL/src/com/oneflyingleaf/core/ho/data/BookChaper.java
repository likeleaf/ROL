package com.oneflyingleaf.core.ho.data;

import java.io.File;

import com.oneflyingleaf.core.util.FileUtils;

// default package



/**
 * BookChaper entity. @author MyEclipse Persistence Tools
 */

public class BookChaper  implements java.io.Serializable {


    // Fields    

     private Integer bookChaId;
     private String bookPartId;
     private String bookChaCon;
     private Integer bookChaIndex;
     private String bookChaTitle;
     private String bookId;
     private String text;
     private int wordSize;



   
    // Property accessors


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
   
	/**
	 * 用于显示
	 * @return
	 */
	public String getText(){
		if(bookChaCon == null) return "";
		if(text == null){
			text = FileUtils.getFileContent(new File(bookChaCon)).toString();
		}
		//System.out.println(text);
		return text;
	}
	
	/**
	 * 用于下载
	 * @return
	 */
	public String getText2(){
		if(bookChaCon == null) return "";
		if(text == null){
			text = FileUtils.getFileContent2(new File(bookChaCon)).toString();
		}
		return text;
	}

	public int getWordSize() {
		return getText().length();
	}

	public String getRealCon(){
		return this.bookChaCon;
	}

	public Integer getBookChaId() {
		return bookChaId;
	}

	public void setBookChaId(Integer bookChaId) {
		this.bookChaId = bookChaId;
	}




}