package com.bookmanagement.booklendingsystem.responses;

import com.bookmanagement.booklendingsystem.entities.BlackList;
import com.bookmanagement.booklendingsystem.entities.BorrowBook;

public class BlackListResponse {

    Long id;
    Long borrowBookId;
    String bookName;
    String personName;

    Long personTc;
    public BlackListResponse(BlackList entity){
        this.id=entity.getId();
        this.borrowBookId=entity.getBorrowBook().getId();
        this.personName=entity.getBorrowBook().getPerson().getNameSurname();
        this.bookName=entity.getBorrowBook().getBook().getBookName();
        this.personTc=entity.getBorrowBook().getPerson().getTc();
    }

    public Long getPersonTc() {
        return personTc;
    }

    public void setPersonTc(Long personTc) {
        this.personTc = personTc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBorrowBookId() {
        return borrowBookId;
    }

    public void setBorrowBookId(Long borrowBookId) {
        this.borrowBookId = borrowBookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
