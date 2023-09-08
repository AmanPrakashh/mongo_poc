package com.code.mongoCrud.controller;


import com.code.mongoCrud.collection.Person;
import com.code.mongoCrud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping
    public Person save(@RequestBody Person person)
    {
        return personService.save(person);
    }

}
