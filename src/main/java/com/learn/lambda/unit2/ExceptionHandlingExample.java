package com.learn.lambda.unit2;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class ExceptionHandlingExample {

    public static void main(String[] args) {
        int[] someArray = {11, 23, 54, 56};
        int key1 = 2;
        int key2 = 0;

        process(someArray, key1, (val, k) -> System.out.println(val / k)); // providing an implementation of BiConsumer accept(T,U)

        process2(someArray, key2, wrappedLambda((val, k) -> System.out.println(val / k))); // providing an implementation of BiConsumer accept(T,U)
    }

    private static void process(int[] someNumbers, int key1, BiConsumer<Integer, Integer> biConsumer) {
        for (int i : someNumbers) {
            biConsumer.accept(i, key1);
        }
    }

    private static void process2(int[] someNumbers, int key2, BiConsumer<Integer, Integer> biConsumer) {
        for (int i : someNumbers) {
            biConsumer.accept(i, key2); // this invoked wrappedLambda accept -> main()
        }
    }

    private static BiConsumer<Integer, Integer> wrappedLambda(BiConsumer<Integer, Integer> biConsumer) {
        return (v,k) -> {
            try {
                biConsumer.accept(v, k); // here exception handling should happen
            } catch(ArithmeticException ex) {
                System.out.println("Arithmetic exception is caught in wrappedLambda");
            }
        }; // return BiConsumer as an input for process2()
    }


}
