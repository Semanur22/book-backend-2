package com.bookmanagement.booklendingsystem.controllers;

import com.bookmanagement.booklendingsystem.Services.BorrowBookService;
import com.bookmanagement.booklendingsystem.entities.Book;
import com.bookmanagement.booklendingsystem.entities.BorrowBook;
import com.bookmanagement.booklendingsystem.entities.Person;
import com.bookmanagement.booklendingsystem.requests.BorrowBookRequest;
import com.bookmanagement.booklendingsystem.requests.BorrowBookUpdateRequest;
import com.bookmanagement.booklendingsystem.responses.BorrowBookResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api/borrowBooks")
public class BorrowBookController {
    private BorrowBookService borrowBookService;

    public BorrowBookController(BorrowBookService borrowBookService) {
        this.borrowBookService = borrowBookService;
    }
    @GetMapping
    public List<BorrowBookResponse> getAllBorrowBooks(@RequestParam Optional<Long> personId, @RequestParam Optional<Long> bookId){
        return borrowBookService.getAllBorrowList(personId,bookId);
    }
    @GetMapping("/{borrowBookId}")
    public BorrowBook getOneBorrowBook(@PathVariable Long borrowBookId){
        return borrowBookService.findByBorrowBookId(borrowBookId);
    }

    @PostMapping
    public BorrowBook postOneBorrowBook(@RequestBody BorrowBookRequest newBorrowBookRequest){
        return borrowBookService.saveBorrowBook(newBorrowBookRequest);
    }

    @PutMapping("/{borrowBookId}")
    public BorrowBook putOneBorrowBook(@PathVariable Long borrowBookId, @RequestBody BorrowBookUpdateRequest borrowBookUpdateRequest){
        return borrowBookService.updateBorrowBookById(borrowBookId,borrowBookUpdateRequest);

    }

    @DeleteMapping("/{borrowBookId}")
    public void deleteOneBorrowBook(@PathVariable Long borrowBookId) {
        borrowBookService.deleteBorrowBookById(borrowBookId);
    }

    @PutMapping("/blackList/{borrowBookId}")  //onyuzde carpıya bastigi zaman direk blackliste ataması icin
    public BorrowBook blackList(@PathVariable Long borrowBookId){
        return borrowBookService.blackList(borrowBookId);
    }

/*
    @PutMapping("/addBookFromBB/{borrowBookId}")
    public Book addBookFromBorrowBook(@RequestBody Book book,@PathVariable Long borrowBookId){
        return borrowBookService.addBookFromBBook(book,borrowBookId);
    }
*/
}
