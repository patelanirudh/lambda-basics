package com.learn.lambda.unit1;

public class RunnableExample {

    public static void main(String[] args) {
        Thread myThread = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Thread : " + Thread.currentThread().getName() + ", Printed inside runnable");
            }
        }, "RunnableThread");

        // We can do this since Runnable Interface has a single run() which matches with the lambda expression == Just like Greeting Interface
        Thread myThread2 = new Thread(() -> System.out.println("Thread : " + Thread.currentThread().getName() + ", Lambda Printed inside runnable"),
                "LambdaThread");

        myThread.start();
        myThread2.start();
    }
}
