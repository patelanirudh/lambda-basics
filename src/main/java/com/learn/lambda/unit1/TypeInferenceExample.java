package com.learn.lambda.unit1;

public class TypeInferenceExample {

    public static void main(String[] args) {
        StringLengthLambda stringLambda = (String s) -> s.length(); // implementation of Lambda Interface
        StringLengthLambda stringLambda1 = (s) -> s.length(); // type inference for input argument
        StringLengthLambda stringLambda2 = s -> s.length(); // type inference for single input argument remove ()

        System.out.println("StringLengthLambda count : " + stringLambda.getLength("Anirudh Patel"));
        print(stringLambda);
        print(stringLambda1);
        print(stringLambda2);
        print(s -> s.length()); // type inference while passing lambda expresssion
    }

    public static void print(StringLengthLambda sLambda) {
        System.out.println("StringLengthLambda " + sLambda.getClass() + ", Inside Function count : " + sLambda.getLength("Shilpi Patel"));
    }

    interface StringLengthLambda {
        int getLength(String s);
    }
}
