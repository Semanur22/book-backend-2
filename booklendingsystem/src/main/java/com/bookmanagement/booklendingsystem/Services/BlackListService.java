package com.bookmanagement.booklendingsystem.Services;


import com.bookmanagement.booklendingsystem.entities.BlackList;
import com.bookmanagement.booklendingsystem.entities.Book;
import com.bookmanagement.booklendingsystem.entities.BorrowBook;
import com.bookmanagement.booklendingsystem.entities.Person;
import com.bookmanagement.booklendingsystem.repositories.BlackListRepository;
import com.bookmanagement.booklendingsystem.requests.BlackListRequest;

import com.bookmanagement.booklendingsystem.requests.BorrowBookRequest;
import com.bookmanagement.booklendingsystem.responses.BlackListResponse;
import com.bookmanagement.booklendingsystem.responses.BorrowBookResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class BlackListService {
    private BlackListRepository blackListRepository;
    private BorrowBookService borrowBookService;

    public BlackListService(BlackListRepository blackListRepository, BorrowBookService borrowBookService) {
        this.blackListRepository = blackListRepository;
        this.borrowBookService = borrowBookService;
    }

    public BlackList save(BlackListRequest newBlackListRequest){
        BorrowBook borrowBook= borrowBookService.findByBorrowBookId(newBlackListRequest.getBorrowBookId());
        BlackList toSave=new BlackList();
        toSave.setId(newBlackListRequest.getId());
        toSave.setBorrowBook(borrowBook);

        return blackListRepository.save(toSave);
    }

    public List<BlackListResponse> getAllBlackList(Optional<Long> borrowBookId){

        List<BlackList> blackLists;
        if(borrowBookId.isPresent()) {
            blackLists = blackListRepository.findByBorrowBookId(borrowBookId.get());
        }else
            blackLists = blackListRepository.findAll();
        return blackLists.stream().map(blackList -> new BlackListResponse(blackList)).collect(Collectors.toList());
    }


    public void deleteById(Long blackId) {
        blackListRepository.deleteById(blackId);
    }
}
