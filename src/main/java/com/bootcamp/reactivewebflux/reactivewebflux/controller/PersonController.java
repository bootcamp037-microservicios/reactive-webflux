package com.bootcamp.reactivewebflux.reactivewebflux.controller;

import com.bootcamp.reactivewebflux.reactivewebflux.model.Person;
import com.bootcamp.reactivewebflux.reactivewebflux.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping()
    public Flux<Person> findAll(){
        return personService.findAll();
    }

    @PostMapping()
    public Mono<Person> save(@RequestBody Person p){
        return personService.save(p);
    }

    @PutMapping()
    public Mono<Person> update(@RequestBody Person p){
        return personService.update(p);
    }

    @GetMapping(value = "/{id}")
    public Mono<Person> findById(@PathVariable("id") String id){
        return personService.getId(id);
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Void> delete(@PathVariable("id") String id){
        return personService.delete(id);
    }

}
