package com.learn.lambda.unit2;

public class ThisReferenceExample {

    public void doProcess(int val, Process p) {
        p.process(val);
    }

    public void execute(int ii) {
        // this == ThisReferenceExample class instance
        doProcess(ii, (i) -> {
            System.out.println("Execute() : Value of i is " + i);
            System.out.println(this); // we can access 'this'
        });
    }

    public static void main(String[] args) {
        ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
        thisReferenceExample.doProcess(10, new Process() {
            @Override
            public void process(int i) {
                System.out.println("Value of i is " + i);
                System.out.println(this); // no error even inside static main because 'this' is referring to Anonymous class
            }

            @Override
            public String toString(){
                return "This is the anonymous class instance";
            }
        });

        thisReferenceExample.doProcess(20, (i) -> {
            System.out.println("Inline Lambda Value of i is " + i);
            // you cannot refer this inside a static method
            // System.out.println(this); // this would show an error as lambda expr is not creating an anonymous class,
        });

        thisReferenceExample.execute(30);
    }

    public String toString() {
        return "This is the 'ThisReferenceExample' class instance";
    }

    interface Process {
        void process(int i);
    }
}
