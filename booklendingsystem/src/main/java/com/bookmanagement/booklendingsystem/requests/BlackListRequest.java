package com.bookmanagement.booklendingsystem.requests;

public class BlackListRequest {
    Long id;
    Long borrowBookId;

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
}
