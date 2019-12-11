package com.knoldus.functionaljava.lambda;

import java.util.Arrays;
import java.util.List;

public class Closures {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // Here the lambda is dependent on external variable factor.
        // This variable must be final or effective final

        // ================= Effective Final===================
        int factor = 5; // Effective final
        list.stream().map(x -> x * factor)
                .forEach(System.out::println);

        /*If uncomment the below line, code will not be compiled as we are trying to
         change the factor which is an effective final variable*/

        // factor = 3;


        // ================= Final=============================
        final int factor1 = 2; // Final
        list.stream().map(x -> x * factor1)
                .forEach(System.out::println);


        // ================= Cheating with effective final=============================

        /*
        Here, factor2 is an array and effective final variable. We have changed the value of an
        array, not the reference, therefore it is allowed. But this is not the best practice.
         */
        int[] factor2 = new int[]{10};
        list.stream().map(x -> x * factor2[0])
                .forEach(System.out::println);
        factor2[0] = 4;

    }
}
