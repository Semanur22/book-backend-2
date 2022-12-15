package com.bookmanagement.booklendingsystem.responses;

import com.bookmanagement.booklendingsystem.entities.BorrowBook;

//databaseden istedigimiz kisimlari gostermesini sagliyoruz mesala sifre gostermemeli
public class BorrowBookResponse {
    Long id;
    Long personId;
    Long bookId;
    String personName;
    Long personTc;
    String bookName;

    int day;
    int black;

    public BorrowBookResponse(BorrowBook entity){
        this.id=entity.getId();
        this.personId=entity.getPerson().getId();
        this.bookId=entity.getBook().getId();
        this.personName=entity.getPerson().getNameSurname();
        this.personTc=entity.getPerson().getTc();
        this.bookName=entity.getBook().getBookName();
        this.day=entity.getDay();
        this.black=entity.getBlack();
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getBlack() {
        return black;
    }

    public void setBlack(int black) {
        this.black = black;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Long getPersonTc() {
        return personTc;
    }

    public void setPersonTc(Long personTc) {
        this.personTc = personTc;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
