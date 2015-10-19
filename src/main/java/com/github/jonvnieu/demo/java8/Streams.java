package com.github.jonvnieu.demo.java8;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <h1>Definition of a {@link java.util.stream.Stream}</h1>
 * A Stream is a sequence of elements (similar to an {@link java.util.Iterator}) that supports parallel execution.
 */
public class Streams {

    public static void main(String[] args) {
        /*******************************************
         * Example 1: Acquiring a Stream reference *
         *******************************************/

        // From a Collection
        Collection<String> stringCollection = Arrays.asList("apple", "banana", "coconut");
        Stream<String> stringStream = stringCollection.stream();

        // From a Generator
        Random random = new Random();
        Stream<Integer> randomStream = Stream.generate(random::nextInt);
        IntStream rangeIntStream = IntStream.range(0, 10);

        /************************************
         * Example 2: Operators on a Stream *
         ************************************/

        // Printing Strings that contain the letter A
        stringStream.filter(string -> string.contains("a")).forEach(System.out::println);

        // Statistical operations on integers:
        System.out.println("Sum of [0,10) is: " + IntStream.range(0, 10).sum());
        OptionalDouble averageRangeOptional = IntStream.range(0, 10).average(); // Caveat: a stream is not reusable!
        if (averageRangeOptional.isPresent()) {
            System.out.println("Mean of [0,10) is: " + averageRangeOptional.getAsDouble());
        }

        // Printing the square of the even numbers in range [0,10)
        IntStream.range(0, 10).filter(i -> (i % 2) == 0).map(i -> i * i).forEach(System.out::println);

        // Mapping an object on one of its members
        List<Person> persons = new ArrayList<>(5);
        persons.add(new Person("Simpson", "Bart", LocalDate.of(1989, 5, 1)));
        persons.add(new Person("De Wever", "Bart", LocalDate.of(1970, 12, 21)));
        persons.add(new Person("Lived", "Eht", LocalDate.of(1966, 6, 6)));
        persons.add(new Person("Banner", "Bruce", LocalDate.of(1980, 4, 20)));
        persons.add(new Person("Dickinson", "Bruce", LocalDate.of(1958, 8, 7)));
        List<String> uniqueSurnames = persons.stream().map(Person::surname).distinct().collect(Collectors.toList());
        System.out.println(uniqueSurnames);
        OptionalDouble averageAgeOptional = persons.stream().mapToLong(Person::age).average();
        if (averageAgeOptional.isPresent()) {
            System.out.println("The average age is: " + averageAgeOptional.getAsDouble());
        }
    }
}
