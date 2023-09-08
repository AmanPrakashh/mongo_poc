package com.code.mongoCrud.service.impl;

import com.code.mongoCrud.collection.Person;
import com.code.mongoCrud.repository.PersonRepository;
import com.code.mongoCrud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;
    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }
}
