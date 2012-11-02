package com.berinle.sq.service.impl;

import com.berinle.sq.dao.PersonDao;
import com.berinle.sq.domain.Person;
import com.berinle.sq.service.PersonService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.InjectionMetadata;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired private PersonDao personDao;

    public List<Person> getPersons() {
        return personDao.getPersons();
    }

    @Cacheable(value = "persons")
    public List<Person> getCachedPersons() {
        return personDao.getPersons();
    }
}
