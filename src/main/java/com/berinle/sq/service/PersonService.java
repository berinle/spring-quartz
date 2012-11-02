package com.berinle.sq.service;

import com.berinle.sq.domain.Person;

import java.util.List;

public interface PersonService {
    List<Person> getPersons();
    List<Person> getCachedPersons();
}
