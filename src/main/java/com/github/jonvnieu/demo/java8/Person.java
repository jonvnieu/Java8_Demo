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

    /**
     * Creates a new instance with given name, surname and date of birth.
     *
     * @param name        the name of this person
     * @param surname     the surname of this person
     * @param dateOfBirth the date of birth of this person
     */
    public Person(String name, String surname, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the name of this person
     */
    public String name() {
        return name;
    }

    /**
     * @return the surname of this person
     */
    public String surname() {
        return surname;
    }

    /**
     * Calculates the age, using the {@link java.time} package.
     *
     * @return the current age of this person
     */
    public long age() {
        return dateOfBirth.until(Instant.now().atZone(ZoneId.systemDefault()).toLocalDate(), ChronoUnit.YEARS);
    }

    /**
     * @return a string representation of this person
     */
    @Override
    public String toString() {
        return name().toUpperCase() + " " + surname() + "(Age " + age() + ")";
    }
}
