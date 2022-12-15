package com.bookmanagement.booklendingsystem.controllers;

import com.bookmanagement.booklendingsystem.Services.PersonService;
import com.bookmanagement.booklendingsystem.entities.Person;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAllPersons(){
        return  personService.getAllPersons();
    }

    @PostMapping
    public Person postOnePerson(@Valid  @RequestBody Person newPerson){
        return personService.save(newPerson);
    }

    @GetMapping("/{personId}")
    public Person getOnePerson(@PathVariable Long personId){
        return personService.findByPersonId(personId);
    }

    @PutMapping("/{personId}")
    public Person putOnePerson(@PathVariable Long personId, @RequestBody Person newPerson){
        return personService.update(personId,newPerson);
    }

    @DeleteMapping("/{personId}")
    public void deleteOnePerson(@PathVariable Long personId){
        personService.deleteById(personId);
    }

}
