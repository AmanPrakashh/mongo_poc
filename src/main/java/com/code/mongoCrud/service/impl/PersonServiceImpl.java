package com.code.mongoCrud.service.impl;

import com.code.mongoCrud.collection.Person;
import com.code.mongoCrud.repository.PersonRepository;
import com.code.mongoCrud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
   private PersonRepository personRepository;

    @Autowired
    private MongoTemplate  mongoTemplate;
    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> getPersonStartWith(String name) {
        return personRepository.findByFirstNameStartsWith(name);
    }

    @Override
    public String delete(String id) {

        personRepository.findById(id);
        if(personRepository.findById(id)!=null)
        {
            return "person not available";
        }
        personRepository.deleteById(id);
        return "deleted";
    }

    @Override
    public List<Person> getByPersonAge(Integer minAge, Integer maxAge) {
        return personRepository.findPersonByAgeBetween(minAge, maxAge);
    }

    @Override
    public Page<Person> search(String name, String minAge, String maxAge, String city, Pageable pageable) {
        return null;
    }

//    @Override
//    public Page<Person> search(String name, String minAge, String maxAge, String city, Pageable pageable) {
//        Query query = new Query().with(pageable);
//        List<Criteria> criteria = new ArrayList<>();
//        if (name != null && !name.isEmpty()) {
//            criteria.add(Criteria.where("firstName").regex(name, "i"));
//        }
//        if (minAge != null && maxAge != null) {
//            criteria.add(Criteria.where("age").gte(minAge).lte(maxAge));
//        }
//        if (city != null && !city.isEmpty()) {
//            criteria.add(Criteria.where("addresses.city").regex(city, "i"));
//        }
//
//        if (!criteria.isEmpty()) {
//            query.addCriteria(new Criteria().andOperator());
//        }
//        return null;
//    }


}
