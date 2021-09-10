package com.company.validator;

public class Person {

    private String firstName;
    private String lastName;
    @Min(18)
    private int age;
    @AssertTrue
    private boolean isAuthorized;

    public Person(String firstName, String lastName, int age, boolean isAuthorized) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isAuthorized = isAuthorized;
    }
}
