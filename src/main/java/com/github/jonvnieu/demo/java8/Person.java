package com.github.jonvnieu.demo.java8;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

/**
 * A simple class to represent a person.
 */
public final class Person {

    private final String name;
    private final String surname;
    private final LocalDate dateOfBirth;

    public Person(String name, String surname, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public String name() {
        return name;
    }

    public String surname() {
        return surname;
    }

    /**
     * Calculates the age, using the {@link java.time} package.
     * @return the current age of this person
     */
    public long age() {
        return dateOfBirth.until(Instant.now().atZone(ZoneId.systemDefault()).toLocalDate(), ChronoUnit.YEARS);
    }
}
