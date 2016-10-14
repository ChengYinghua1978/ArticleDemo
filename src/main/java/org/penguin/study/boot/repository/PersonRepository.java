package org.penguin.study.boot.repository;

import org.penguin.study.boot.domain.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by terry on 14/10/2016.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {
}
