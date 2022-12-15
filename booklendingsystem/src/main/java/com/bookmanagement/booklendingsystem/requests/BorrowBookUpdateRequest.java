package com.bookmanagement.booklendingsystem.requests;

public class BorrowBookUpdateRequest {
    int day;

    int black;

    public int getBlack() {
        return black;
    }

    public void setBlack(int black) {
        this.black = black;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
