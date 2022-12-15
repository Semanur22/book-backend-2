package com.bookmanagement.booklendingsystem.repositories;

import com.bookmanagement.booklendingsystem.entities.BlackList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlackListRepository extends JpaRepository<BlackList, Long> {
    List<BlackList> findByBorrowBookId(Long aLong);
}
