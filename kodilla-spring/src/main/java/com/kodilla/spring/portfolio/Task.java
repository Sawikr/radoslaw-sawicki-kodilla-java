package com.kodilla.spring.portfolio;

public class Task {

    private final String firstName;
    private final String surname;

    public Task(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Task {" +
                "firstName = '" + firstName + '\'' +
                ", surname = '" + surname + '\'' +
                '}';
    }
}
