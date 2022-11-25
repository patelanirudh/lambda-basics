package com.learn.lambda.unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Unit1ExerciseSolutionLambda {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Ani", "Patrick", 35),
                new Person("Shi", "Dickens", 36),
                new Person("Shweta", "Patel", 30),
                new Person("John", "Young", 60),
                new Person("Dummy", "Agarwal", 20)
        );

        // Step 1 : Sort List By Name
        Collections.sort(people, (Person o1, Person o2) -> {
            return o1.getLastName().compareTo(o2.getLastName()); // this is an implementation of compare()
        });

        // Step 2 : Create a method that prints all elements in the list
        // printAll(people);
        printConditionally(people, (Person p) -> true); // prints everything since return is always "true"

        // Step 3 : Create a method that all people that have last name beginning with P
        System.out.println("Person(s) will lastName starting with P");
        printConditionally(people, (Person p) -> p.getLastName().startsWith("P"));
        printConditionallySecondWay(people, (Person p) -> p.getLastName().startsWith("P"));


        System.out.println("Person(s) will firstName starting with J");
        printConditionally(people, (Person p) -> p.getFirstName().startsWith("J"));
    }

    @FunctionalInterface
    interface Conditional {
        boolean test(Person p);
    }

    private static void printAll(List<Person> people) {
        for (Person person : people) {
            System.out.println("Sorted List " + person);
        }
    }

    private static void printConditionally(List<Person> people, Conditional condition) {
        for (Person p : people) {
            if (condition.test(p))
                System.out.println("Person : " + p);
        }
    }

    private static void printConditionallySecondWay(List<Person> people, Predicate<Person> predicate) {
        for (Person p : people) {
            if (predicate.test(p))
                System.out.println("Person : " + p);
        }
    }
}
