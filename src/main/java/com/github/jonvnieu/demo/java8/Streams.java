package com.github.jonvnieu.demo.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <h1>Definition of a {@link java.util.stream.Stream}</h1>
 * A Stream is a sequence of elements (similar to an {@link java.util.Iterator}) that supports parallel execution.
 * Operations on a Stream create a stream pipeline.
 * Streams are computed lazily, no operations are done until a terminal operator is called on the stream pipeline.
 */
public class Streams {

    public static void main(String[] args) {
        /*******************************************
         * Example 1: Acquiring a Stream reference *
         *******************************************/

        // From a Collection
        Collection<String> stringCollection = Arrays.asList("apple", "banana", "coconut");
        stringCollection.stream();

        // From a Generator
        Random randomSeed = new Random();
        Stream.generate(randomSeed::nextInt); // Note: this is an infinite stream!
        randomSeed.ints(); // Similar to the above statement
        IntStream.range(0, 10);

        // From a File
        try {
            Files.lines(Paths.get("A File Path"));
        } catch (IOException e) {
            // Will always fail since there is no such file.
        }

        /*************************************
         * Example 2: Some Stream Operations *
         *************************************/

        // Printing Strings that contain the letter A
        stringCollection.stream().filter(string -> string.contains("a"));

        // The sum of the squares of the even numbers in range [0,10)
        IntStream.range(0, 10).filter(i -> (i % 2) == 0).map(i -> i * i).reduce(0, (a, b) -> a + b);

        // Limiting an infinite stream
        Stream.generate(randomSeed::nextInt).limit(10);

        /*************************
         * Example 3: Collectors *
         *************************/

        // Gathering the unique surnames given a list of Persons
        List<Person> persons = new ArrayList<>(5);
        persons.add(new Person("Simpson", "Bart", LocalDate.of(1989, 5, 1)));
        persons.add(new Person("De Wever", "Bart", LocalDate.of(1970, 12, 21)));
        persons.add(new Person("Lived", "Eht", LocalDate.of(1966, 6, 6)));
        persons.add(new Person("Banner", "Bruce", LocalDate.of(1980, 4, 20)));
        persons.add(new Person("Dickinson", "Bruce", LocalDate.of(1958, 8, 7)));
        persons.stream().map(Person::surname).distinct().collect(Collectors.toList());

        /*************************************
         * Example 4: Statistical Operations *
         *************************************/

        // Statistical operations on integers:
        IntStream.range(0, 10).sum();
        IntStream.range(0, 10).average().getAsDouble(); // Caveat: a stream is not reusable!

        // Or calculate all statistics in one iteration over the Stream
        IntSummaryStatistics summaryStatistics = IntStream.range(0, 10).summaryStatistics();
        summaryStatistics.getSum();
        summaryStatistics.getCount();
        summaryStatistics.getMin();
        summaryStatistics.getMin();
        summaryStatistics.getAverage();
    }
}
