package org.penguin.study.boot.api.controller;

import org.penguin.study.boot.domain.Person;
import org.penguin.study.boot.wrapper.CustomGenericException;
import org.penguin.study.boot.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by terry on 14/10/2016.
 */

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonRepository personRepository;

	@RequestMapping(method = RequestMethod.POST)
	public Person createOrUpdate(@RequestBody  Person person) {
		return personRepository.save(person);
	}

	@RequestMapping(value = "/{personId}/detail", method = RequestMethod.GET)
	public Person getAuthorDetails(@PathVariable Long personId) throws Exception {
		if (personId == null) {
			throw new Exception("用户不存在");
		}

		Person person = personRepository.findOne(personId);
		if (person == null) {
			throw new Exception("用户不存在");
		}

		return person;
	}

	@ExceptionHandler(Throwable.class)
	public CustomGenericException handleAllException(Throwable e) {
		return new CustomGenericException("-100", e.getLocalizedMessage());
	}


}