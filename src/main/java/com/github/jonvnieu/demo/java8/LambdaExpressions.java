package com.github.jonvnieu.demo.java8;

import java.time.LocalDate;
import java.util.*;

/**
 * <h1>Syntax of a Lambda Expression</h1>
 * (parameters) -> {body}
 * <ul>
 * <li>Declaring the types of the parameters is optional.</li>
 * <li>Parentheses around the parameter are optional if you have only one parameter.</li>
 * <li>Curly braces for the body are optional (unless you need multiple statements).</li>
 * <li>The "return" keyword is optional if you have a single expression that returns a value.</li>
 * </ul>
 */

public class LambdaExpressions {

    public static void main(String[] args) {
        /*********************************************
         * Example 1: The {@link Runnable} interface *
         *********************************************/

        // Using an anonymous Class:
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World - Runnable 1");
            }
        };

        // Using a Lambda Expression:
        Runnable r2 = () -> System.out.println("Hello World - Runnable 2");

        // Using a Method Reference:
        Runnable r3 = LambdaExpressions::sayHello;

        r1.run();
        r2.run();
        r3.run();

        /*******************************
         * Example 2: Sorting of Lists *
         *******************************/

        List<String> someStrings = Arrays.asList("Batman", "Bruce Wayne", "Superman", "Clark Kent");
        System.out.println("Original Strings: " + someStrings);

        someStrings.sort((first, second) -> (first.length() - second.length()));
        System.out.println("Sorted on length: " + someStrings);

        someStrings.sort(Comparator.comparingInt(String::length).reversed());
        System.out.println("Reverse sorted on lenth: " + someStrings);


        // Sorting a non-primitive class Person
        List<Person> persons = new ArrayList<>(6);
        persons.add(new Person("Simpson", "Bart", LocalDate.of(1989, 5, 1)));
        persons.add(new Person("De Wever", "Bart", LocalDate.of(1970, 12, 21)));
        persons.add(new Person("Lived", "Eht", LocalDate.of(1966, 6, 6)));
        persons.add(new Person("Banner", "Bruce", LocalDate.of(1980, 4, 20)));
        persons.add(new Person("Dickinson", "Bruce", LocalDate.of(1958, 8, 7)));
        persons.add(new Person("Dickinson II", "Bruce", LocalDate.of(1958, 8, 7)));
        System.out.println("Original Persons: " + persons);
        persons.sort(Comparator.comparing(Person::age).thenComparing(Person::name).thenComparing(Person::surname));
        System.out.println("Sorted Persons: " + persons);

//        // Java 7 alternative:
//        Collections.sort(persons, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                if (!o1.surname().equals(o2.surname())) {
//                    return o1.surname().compareTo(o2.surname());
//                } else {
//                    long age1 = o1.age();
//                    long age2 = o2.age();
//                    if (age1 != age2) {
//                        return Long.compare(age1, age2);
//                    } else {
//                        return o1.name().compareTo(o2.name());
//                    }
//                }
//            }
//        });
    }

    private static void sayHello() {
        System.out.println("Hello World - LambdaExpressions.class");
    }
}
