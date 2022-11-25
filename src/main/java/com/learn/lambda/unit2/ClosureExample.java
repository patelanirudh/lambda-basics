package com.learn.lambda.unit2;

public class ClosureExample {

    public static void main(String[] args) {
        int a = 10;
        int b = 20; // effectively final. Compiler freezes b's value for below lambda via closure
        System.out.println("Value of b before labmda execution : " + b);
        print(a, (i) -> System.out.println("Lambda Implementation Result is " + (i + b)));

//        b = 30; will complain if we do this as 'b' has to be final or effectively final
        System.out.println("Value of b after labmda execution : " + b);

    }

    private static void print(int i, Process p) {
        p.process(i); // calls above lambda implementation even it does not have b here
        // compiler is not passing b\s value but frozen it before
    }

    interface Process {
        void process(int i);
    }
}
