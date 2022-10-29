package com.bootcamp.reactivewebflux.reactivewebflux.dao;

import com.bootcamp.reactivewebflux.reactivewebflux.model.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PersonRepository extends ReactiveCrudRepository <Person, String> {

}
