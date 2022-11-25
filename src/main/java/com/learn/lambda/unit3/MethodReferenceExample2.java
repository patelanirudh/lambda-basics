package com.learn.lambda.unit3;

import com.learn.lambda.unit1.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExample2 {

    public static void main(String[] args) {


        List<com.learn.lambda.unit1.Person> people = Arrays.asList(
                new Person("Ani", "Patrick", 35),
                new Person("Shi", "Dickens", 36),
                new Person("Shweta", "Patel", 30),
                new Person("John", "Young", 60),
                new Person("Dummy", "Agarwal", 20)
        );

        // Step 2 : Create a method that prints all elements in the list
        // printAll(people);
        // providing an implementation of Consumer's accept(T)
        // prints everything since return is always "true"
        printConditionallySecondWay(people, (Person p) -> true, System.out::println); // (p) -> method(p) like Consumer accept(T)
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