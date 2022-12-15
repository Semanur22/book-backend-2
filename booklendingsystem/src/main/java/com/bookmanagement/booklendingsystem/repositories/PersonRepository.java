package com.bookmanagement.booklendingsystem.repositories;

import com.bookmanagement.booklendingsystem.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

}
