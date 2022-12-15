package com.bookmanagement.booklendingsystem.Services;

import com.bookmanagement.booklendingsystem.entities.Book;
import com.bookmanagement.booklendingsystem.entities.BorrowBook;
import com.bookmanagement.booklendingsystem.entities.Person;
import com.bookmanagement.booklendingsystem.requests.BorrowBookRequest;
import com.bookmanagement.booklendingsystem.responses.BorrowBookResponse;
import com.bookmanagement.booklendingsystem.requests.BorrowBookUpdateRequest;
import org.springframework.stereotype.Service;
import com.bookmanagement.booklendingsystem.repositories.BorrowBookRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class BorrowBookService {
    private BorrowBookRepository borrowBookRepository;
    private PersonService personService;

    private BookService bookService;

    public BorrowBookService(BorrowBookRepository borrowBookRepository, PersonService personService, BookService bookService) {
        this.borrowBookRepository = borrowBookRepository;
        this.personService = personService;
        this.bookService = bookService;
    }

    public List<BorrowBookResponse> getAllBorrowList(Optional<Long> personId, Optional<Long> bookId){

        List<BorrowBook> borrowBooks;
        if(personId.isPresent() && bookId.isPresent()) {
            borrowBooks = borrowBookRepository.findByPersonIdAndBookId(personId.get(), bookId.get());
        }else if(personId.isPresent()) {
            borrowBooks = borrowBookRepository.findByPersonId(personId.get());
        }else if(bookId.isPresent()) {
            borrowBooks = borrowBookRepository.findByBookId(bookId.get());
        }else
            borrowBooks = borrowBookRepository.findAll();
        return borrowBooks.stream().map(borrowBook -> new BorrowBookResponse(borrowBook)).collect(Collectors.toList());
    }

    public BorrowBook findByBorrowBookId(Long id){
        return borrowBookRepository.findById(id).orElse(null);
    }


    public BorrowBook saveBorrowBook(BorrowBookRequest newBorrowBookRequest){
        Person person= personService.findByPersonId(newBorrowBookRequest.getPersonId());

        Book book= bookService.findByBookId(newBorrowBookRequest.getBookId());
        BorrowBook toSave=new BorrowBook();
        toSave.setId(newBorrowBookRequest.getId());
        toSave.setDay(newBorrowBookRequest.getDay());
        toSave.setBlack(newBorrowBookRequest.getBlack());
        toSave.setPerson(person);
        toSave.setBook(book);
        return borrowBookRepository.save(toSave);
    }


    public BorrowBook updateBorrowBookById(Long borrowBookId, BorrowBookUpdateRequest borrowBookUpdateRequest) {
        Optional<BorrowBook> borrowBook=borrowBookRepository.findById(borrowBookId);

            if (borrowBook.isPresent() && borrowBook.get().getA() < borrowBook.get().getB()) {
                BorrowBook borrowBookToUpdate = borrowBook.get();
                borrowBookToUpdate.setBlack(1);
                borrowBookToUpdate.setDay(borrowBookUpdateRequest.getDay());
                return borrowBookRepository.save(borrowBookToUpdate);

        }else
            return null;
    }

    public void deleteBorrowBookById(Long borrowBookId) {
        borrowBookRepository.deleteById(borrowBookId);

    }


    public BorrowBook blackList(Long borrowBookId){
        Optional<BorrowBook> borrowBook=borrowBookRepository.findById(borrowBookId);
        BorrowBook borrowBookToUpdate = borrowBook.get();
        borrowBookToUpdate.setBlack(1);
        return borrowBookRepository.save(borrowBookToUpdate);
    }

/*
    public Book addBookFromBBook(Book book, Long borrowBookId) {
        bookService.save(book);
        Optional<BorrowBook> borrowBook=borrowBookRepository.findById(borrowBookId);
        Book toUpdate=book;
        book.setBookName(borrowBook.get().getBook().getBookName());
        return bookService.save(toUpdate);


    }

 */
}

