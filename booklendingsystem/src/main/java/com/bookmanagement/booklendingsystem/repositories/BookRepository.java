package com.bookmanagement.booklendingsystem.repositories;

import com.bookmanagement.booklendingsystem.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    @Query(value = "select * from books b where b.kitap_ad like %:keyword% ", nativeQuery = true)
    List<Book> findByKeyword(@Param("keyword") String keyword);
}
