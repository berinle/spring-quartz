package com.berinle.sq.dao.impl;

import com.berinle.sq.dao.PersonDao;
import com.berinle.sq.domain.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDaoImpl implements PersonDao {

    @Override
    public List<Person> getPersons() {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("joe", "doe"));
        persons.add(new Person("bob", "lapine"));

        try { //simulate some length computation
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return persons;
    }
}
