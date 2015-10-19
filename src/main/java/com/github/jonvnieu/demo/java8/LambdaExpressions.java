package com.github.jonvnieu.demo.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
        System.out.println("Original List: " + someStrings);

        someStrings.sort((first, second) -> (first.length() - second.length()));
        System.out.println("Sorted on length: " + someStrings);

        someStrings.sort(Comparator.comparingInt(String::length).reversed());
        System.out.println("Reverse sorted on lenth: " + someStrings);
    }

    private static void sayHello() {
        System.out.println("Hello World - LambdaExpressions.class");
    }
}
