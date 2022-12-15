package com.bookmanagement.booklendingsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "black_lists")
public class BlackList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "borrow_book_black", joinColumns = @JoinColumn(name = "black_list_id"), inverseJoinColumns = @JoinColumn(name = "borrow_book_id"))
    @JsonIgnore
    BorrowBook borrowBook;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BorrowBook getBorrowBook() {
        return borrowBook;
    }

    public void setBorrowBook(BorrowBook borrowBook) {
        this.borrowBook = borrowBook;
    }
}
