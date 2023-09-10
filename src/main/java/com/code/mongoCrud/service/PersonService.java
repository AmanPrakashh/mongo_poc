package com.code.mongoCrud.service;

import com.code.mongoCrud.collection.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {
    Person save(Person person);
    
    List<Person> getPersonStartWith(String name);

    String delete(String id);

    List<Person> getByPersonAge(Integer minAge, Integer maxAge);

    Page<Person> search(String name, String minAge, String maxAge, String city, Pageable pageable);
}
