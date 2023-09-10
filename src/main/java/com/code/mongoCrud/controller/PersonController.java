package com.code.mongoCrud.controller;


import com.code.mongoCrud.collection.Person;
import com.code.mongoCrud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping()
    public List<Person> persons(@RequestParam("name") String name)
    {
        return personService.getPersonStartWith(name);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id)
    {
       String result= personService.delete(id);
        return result;
    }

    @GetMapping("/age")
    public List<Person> getByPersonAge(@RequestParam Integer minAge,
                                       @RequestParam Integer maxAge)
    {
        return personService.getByPersonAge(minAge, maxAge);
    }

    @GetMapping("/search")
    public Page<Person> searchPerson(
            @RequestParam (required = false) String name,
            @RequestParam (required = false) String minAge,
            @RequestParam (required = false) String maxAge,
            @RequestParam (required = false) String city ,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "5") Integer size)
    {
        Pageable pageable = PageRequest.of(page,size);
        return personService.search(name, minAge, maxAge, city, pageable);
    }
}

