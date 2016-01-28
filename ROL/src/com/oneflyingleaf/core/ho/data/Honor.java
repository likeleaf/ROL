package com.oneflyingleaf.core.ho.data;



/**
 * Honor entity. @author MyEclipse Persistence Tools
 */

public class Honor  implements java.io.Serializable {


    // Fields    

     private String honorId;
     private Book book;
     private Integer weedClick;
     private Integer dayClick;
     private Long totalClick;
     private Integer weekRec;
     private Integer dayRec;
     private Long totalRec;
     private Double grade;


    // Constructors

    /** default constructor */
    public Honor() {
    }

	/** minimal constructor */
    public Honor(String honorId) {
        this.honorId = honorId;
    }
    
    /** full constructor */
    public Honor(String honorId, Book book, Integer weedClick, Integer dayClick, Long totalClick, Integer weekRec, Integer dayRec, Long totalRec, Double grade) {
        this.honorId = honorId;
        this.book = book;
        this.weedClick = weedClick;
        this.dayClick = dayClick;
        this.totalClick = totalClick;
        this.weekRec = weekRec;
        this.dayRec = dayRec;
        this.totalRec = totalRec;
        this.grade = grade;
    }

   
    // Property accessors

    public String getHonorId() {
        return this.honorId;
    }
    
    public void setHonorId(String honorId) {
        this.honorId = honorId;
    }

    public Book getBook() {
        return this.book;
    }
    
    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getWeedClick() {
        return this.weedClick;
    }
    
    public void setWeedClick(Integer weedClick) {
        this.weedClick = weedClick;
    }

    public Integer getDayClick() {
        return this.dayClick;
    }
    
    public void setDayClick(Integer dayClick) {
        this.dayClick = dayClick;
    }

    public Long getTotalClick() {
        return this.totalClick;
    }
    
    public void setTotalClick(Long totalClick) {
        this.totalClick = totalClick;
    }

    public Integer getWeekRec() {
        return this.weekRec;
    }
    
    public void setWeekRec(Integer weekRec) {
        this.weekRec = weekRec;
    }

    public Integer getDayRec() {
        return this.dayRec;
    }
    
    public void setDayRec(Integer dayRec) {
        this.dayRec = dayRec;
    }

    public Long getTotalRec() {
        return this.totalRec;
    }
    
    public void setTotalRec(Long totalRec) {
        this.totalRec = totalRec;
    }

    public Double getGrade() {
        return this.grade;
    }
    
    public void setGrade(Double grade) {
        this.grade = grade;
    }
   








}