package com.bookmanagement.booklendingsystem.Services;

import com.bookmanagement.booklendingsystem.entities.Person;
import org.springframework.stereotype.Service;
import com.bookmanagement.booklendingsystem.repositories.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }
    public Person save(Person newPerson){
        return personRepository.save(newPerson);
    }

    public Person findByPersonId(Long id){
        return personRepository.findById(id).orElse(null);
    }

    public Person update(Long personId, Person newPerson) {
        Optional<Person> person=personRepository.findById(personId);
        if(person.isPresent()){
            Person foundPerson=person.get();
            foundPerson.setNameSurname(newPerson.getNameSurname());
            foundPerson.setEmail(newPerson.getEmail());
            foundPerson.setTc(newPerson.getTc());
            foundPerson.setPhoneNumber(newPerson.getPhoneNumber());
            return foundPerson;
        }
        else
            return null;
    }



    public void deleteById(Long personId) {
        personRepository.deleteById(personId);
    }

}
