package com.bookmanagement.booklendingsystem.controllers;

import com.bookmanagement.booklendingsystem.Services.BlackListService;
import com.bookmanagement.booklendingsystem.entities.BlackList;
import com.bookmanagement.booklendingsystem.requests.BlackListRequest;
import com.bookmanagement.booklendingsystem.responses.BlackListResponse;
import com.bookmanagement.booklendingsystem.responses.BorrowBookResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api/blackLists")
public class BlackListController {

    private BlackListService blackListService;

    public BlackListController(BlackListService blackListService) {
        this.blackListService = blackListService;
    }

    @PostMapping
    public BlackList postBlack(@RequestBody BlackListRequest newBlackListRequest){
        return blackListService.save(newBlackListRequest);
    }

    @GetMapping
    public List<BlackListResponse> getAllBlackLists(@RequestParam Optional<Long> borrowBookId){
        return blackListService.getAllBlackList(borrowBookId);
    }
    @DeleteMapping("/{blackId}")
    public void deleteFromBlackList(@PathVariable Long blackId) {
        blackListService.deleteById(blackId);
    }
}
