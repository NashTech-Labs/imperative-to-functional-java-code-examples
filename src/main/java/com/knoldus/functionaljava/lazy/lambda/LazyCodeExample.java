package com.knoldus.functionaljava.lazy.lambda;

public class LazyCodeExample {

    /*
    Here, process() will not be evaluated as first operand is returning false.
    But it will become quite difficult to call a function in if condition if it
    is having more than 3 or 4 variables. Code will become messy
     */
    public static void main(String args[]) {
        final int number = 4;
        if (compute(number) && process(number)) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
    }

    private static boolean compute(final int number) {
        System.out.println("computing number : " + number);
        return number > 5;
    }

    private static boolean process(final int number) {
        System.out.println("processing number : " + number);
        return number % 3 == 0;
    }
}
