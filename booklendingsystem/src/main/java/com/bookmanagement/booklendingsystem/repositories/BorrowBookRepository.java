package com.bookmanagement.booklendingsystem.repositories;


import com.bookmanagement.booklendingsystem.entities.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowBookRepository extends JpaRepository<BorrowBook,Long> {


    List<BorrowBook> findByPersonId(Long id); //kullanicinin aldigi ödunc kitaplari listeler (su an gerek yok)


    List<BorrowBook> findByPersonIdAndBookId(Long aLong, Long aLong1);

    List<BorrowBook> findByBookId(Long id);



}
