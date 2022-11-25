package com.learn.lambda.unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1ExerciseSolutionJava7 {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Ani", "Patrick", 35),
                new Person("Shi", "Dickens", 36),
                new Person("Shweta", "Patel", 30),
                new Person("John", "Young", 60),
                new Person("Dummy", "Agarwal", 20)
        );

        // implement the Comparator interface using Anonymous Class
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });

        // Step 2 : Create a method that prints all elements in the list
        printAll(people);

        // Step 3 : Create a method that all people that have last name beginning with P
        System.out.println("Person(s) will lastName starting with P");
        printConditionally(people, new Conditional() {
            @Override
            public boolean test(Person p) {
                return p.getLastName().startsWith("P");
            }
        });

        System.out.println("Person(s) will firstName starting with J");
        printConditionally(people, new Conditional() {
            @Override
            public boolean test(Person p) {
                return p.getFirstName().startsWith("J");
            }
        });

    }

    private static void printConditionally(List<Person> people, Conditional condition) {
        for (Person person : people) {
            if (condition.test(person))
                System.out.println(person);
        }
    }

    private static void printAll(List<Person> people) {
        for (Person person : people) {
            System.out.println("Sorted List " + person);
        }
    }

    interface Conditional {
        boolean test(Person p);
    }
}
