package com.learn.lambda.unit1;

public class Greeter {

    public void greet(Greeting greet) {
        greet.perform();
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter();

        // No Input Args No Return, with Functional Interface as Type : Match Lambda Expression with Func.Int.Type
        MyVoidLambda greetingVoidFunction = () -> System.out.println("Hello world!");
        // This shows already existing interface could be used and the function name inside the interface does not
        // matter. Match this with above.
        Greeting helloWorldGreeting = new HelloWorldGreeting();
        // helloWorldGreeting.perform();

        // Above we have created a class implementation of Greeting interface (could also be done via Anonymous
        // Inner Class).
        // This is a lambda expr. implementing function inside Greeting interface.
        Greeting greetingFunction = () -> System.out.println("Hello from lambda greeting world!");

        greeter.greet(greetingFunction);
        greeter.greet(helloWorldGreeting);

//        doubleNumberFunction = (int a) -> a * 2;

        // 2 Input Args and Return, with Functional Interface as Type : Match Lambda Expression with Func.Int.Type
        MyAddLambda addNumberFunction = (int a, int b) -> a + b;

//        safeDivideFunction = (int a, int b) -> {
//            if (b == 0) return 0;
//            return a / b;
//        };

//        stringLengthFunction = (String s) -> s.length();
    }

    // This is the functional interface
    interface MyVoidLambda {
        void foo();
    }

    interface MyAddLambda {
        int add(int a, int b);
    }
}