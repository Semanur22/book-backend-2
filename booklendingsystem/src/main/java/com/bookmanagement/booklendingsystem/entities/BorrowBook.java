package com.bookmanagement.booklendingsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Entity
@Table(name = "borrow_books")
public class BorrowBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gun_sayisi")
    private int day;

    @Column(name="black_list")
    private int black;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "person_books", joinColumns = @JoinColumn(name = "borrow_book_id"), inverseJoinColumns = @JoinColumn(name = "person_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "borrowed_books", joinColumns = @JoinColumn(name = "borrow_book_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    @JsonIgnore
    Book book;

    private int a=6;
    private int b=5;

    public int getBlack() {
        return black;
    }

    public void setBlack(int black) {
        this.black = black;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }


}
