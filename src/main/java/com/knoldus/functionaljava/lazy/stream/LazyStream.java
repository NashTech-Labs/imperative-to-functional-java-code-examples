package com.knoldus.functionaljava.lazy.stream;

import java.util.Arrays;
import java.util.List;

public class LazyStream {

    private static boolean isGreaterThan5(int number) {
        System.out.println("Is greater tha 5 " + number);
        return number > 5;
    }

    private static boolean isEven(int number) {
        System.out.println("Is even " + number);
        return number % 2 == 0;
    }

    private static int getDouble(int number) {
        System.out.println("Double " + number);
        return number * 2;
    }

    public static void main(String[] args) {

        // FInd the double of the first even number greater than 5
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 8, 10, 11);

        // =================== Imperative Way ===========================

        int result = 0;
        for (int element : list) {
            if (element > 5 && element % 2 == 0) {
                result = element * 2;
                break;
            }
        }

        System.out.println(result);

        // =================== functional Way ===========================

       /* int res = list.stream()
                .filter(LazyStream::isGreaterThan5)
                .filter(LazyStream::isEven)
                .map(LazyStream::getDouble)
                .findFirst()
                .orElse(0);

        System.out.println(res);*/

        // If we will not call the terminal operation on stream then stream will not be evaluated.
        // So lets remove findFirst(). Now you will not see any message on console.
        list.stream()
                .filter(LazyStream::isGreaterThan5)
                .filter(LazyStream::isEven)
                .map(LazyStream::getDouble);

    }
}