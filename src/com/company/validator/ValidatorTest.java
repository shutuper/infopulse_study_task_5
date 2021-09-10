package com.company.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void validate() throws IllegalAccessException {
        // Successful validation if age >= 18 and isAuthorized - true:
        Person person1 = new Person("jame", "lol", 18, true);
        Person person2 = new Person("jame", "lol", 17, true);
        Person person3 = new Person("jame", "lol", 20, false);
        Person person4 = new Person("jame", "lol", 17, false);
        Person person5 = new Person("jame", "lol", 50, true);

        Validator<Person> personValidator = new Validator<>();

        assertTrue(personValidator.validate(person1));
        assertFalse(personValidator.validate(person2));
        assertFalse(personValidator.validate(person3));
        assertFalse(personValidator.validate(person4));
        assertTrue(personValidator.validate(person5));
    }
}