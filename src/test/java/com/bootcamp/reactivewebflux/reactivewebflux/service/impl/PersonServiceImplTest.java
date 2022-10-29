package com.bootcamp.reactivewebflux.reactivewebflux.service.impl;

import com.bootcamp.reactivewebflux.reactivewebflux.model.Person;
import com.bootcamp.reactivewebflux.reactivewebflux.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class PersonServiceImplTest {

    @Autowired
    PersonService personService;

    Person data;

    @Test
    public void when_savePerson_ok(){
        data = new Person();
        data.setDocument("87654321");
        data.setNames("Carlos");
        data.setLastnames("Quispe Martinez");
        data.setStatus(1);

        StepVerifier.create(personService.save(data))
                .expectNext(data)
                .expectComplete()
                .verify();

    }

    @Test
    public void when_getId_error(){
        StepVerifier.create(personService.getId("627d502b827ec662ccc52387"))
                .expectError(RuntimeException.class)
                .verify();
    }

    @Test
    public void when_delete_error(){
        StepVerifier.create(personService.delete("627d502b827ec662ccc52387"))
                .expectError(RuntimeException.class)
                .verify();
    }

}