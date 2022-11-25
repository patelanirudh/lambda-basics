package com.learn.lambda.unit3;

public class MethodReferenceExample1 {
    public static void main(String[] args) {

        Thread t1 = new Thread(MethodReferenceExample1::printMessage); // () -> method : no input and no arg to method()
        // MethodReferenceExample1::printMessage == () -> printMessage()
        t1.start();
    }

    private static void printMessage() {
        System.out.println("Hello");
    }
}
