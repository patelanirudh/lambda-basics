package com.learn.lambda.unit1;

@FunctionalInterface
public interface Greeting {
    public void perform();
    // int add(int, int);
    // cannot add another method as this normal interface will start showing error during assignment as the compiler
    // would not be able to select a target type for the given lambda expression
    // Thus, to avoid others adding another abstract function in this interface mark it as @FunctionalInterface
}
