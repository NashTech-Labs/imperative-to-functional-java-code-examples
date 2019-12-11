package com.knoldus.functionaljava.lazy.lambda;

import java.util.function.Supplier;

public class LambdaLazyCodeExample {

    /*
    Here, Lambda makes it lazy evaluation without messing up the code.
     */
    public static void main(String args[]) {
        final int number = 4;
        final Supplier<Boolean> computeResult = () -> compute(number);
        final Supplier<Boolean> processResult = () -> process(number);
        if (computeResult.get() && processResult.get()) {
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
