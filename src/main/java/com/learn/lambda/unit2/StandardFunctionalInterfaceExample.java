package com.learn.lambda.unit2;

import com.learn.lambda.unit1.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StandardFunctionalInterfaceExample {

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
        // // providing an implementation of Consumer's accept(T)
        printConditionallySecondWay(people, (Person p) -> true, p -> System.out.println(p)); // prints everything since return is always "true"

        // Step 3 : Create a method that all people that have last name beginning with P
        Consumer<Person> consumer1 = (Person p) -> System.out.println(p.getLastName());
        System.out.println("=== Person(s) will lastName starting with P ===");

        //Predicate<Person> P1 = (Person p) -> p.getFirstName().startsWith("A"); Can also use this
        printConditionallySecondWay(people, (Person p) -> p.getLastName().startsWith("P"), consumer1); // providing an implementation of Consumer's accept(T)

        Consumer<Person> consumer2 = (Person p) -> System.out.println(p.getFirstName());
        System.out.println("=== Person(s) will firstName starting with J ===");
        printConditionallySecondWay(people, (Person p) -> p.getFirstName().startsWith("J"), consumer2); // providing an implementation of Consumer's accept(T)
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

    private static void printConditionallySecondWay(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
        for (Person p : people) {
            if (predicate.test(p))
                consumer.accept(p);
        }
    }
}
