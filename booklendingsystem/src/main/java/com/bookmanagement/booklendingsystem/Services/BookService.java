package com.bookmanagement.booklendingsystem.Services;

import com.bookmanagement.booklendingsystem.entities.Book;
import com.bookmanagement.booklendingsystem.entities.Person;
import org.springframework.stereotype.Service;
import com.bookmanagement.booklendingsystem.repositories.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public Book save(Book newBook){
        return bookRepository.save(newBook);
    }

    public Book findByBookId(Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    public List<Book> getByKeyword(String keyword){
        return bookRepository.findByKeyword(keyword);
    }



    public Book update(Long bookId, Book newBook) {
        Optional<Book> book=bookRepository.findById(bookId);
        if(book.isPresent()){
            Book foundBook=book.get();
            foundBook.setBookName(newBook.getBookName());
            return foundBook;
        }
        else
            return null;
    }

    public void deleteById(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
