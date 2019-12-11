package com.knoldus.functionaljava.lazy.lambda;

public class NonLazyCodeExample {

    /*
    Here, both computeResult() and processResult() will get evaluated even if we have used
    && operator which will not evaluate the 2nd operand unless first operand is true.
     */
    public static void main(String args[]) {
        final int number = 4;
        final boolean computeResult = compute(number);
        final boolean processResult = process(number);
        if (computeResult && processResult) {
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
