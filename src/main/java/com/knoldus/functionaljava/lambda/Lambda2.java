package com.knoldus.functionaljava.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Lambda2 {

    public static void main(String[] args) {

        // Print the each element of a list

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);


        // =====================Imperative way ========================


        // 1. External iterator

      /*
      for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
       */

        // 2. Internal Iterator

        /*
        for (int e : list) {
            System.out.println(e);
        }
        */

        // 3. Anonymous class

       /*
       list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        */


        // =====================Functional way ============================

        // 1. Lambda
        // list.forEach(x -> System.out.println(x));

        // 2. Method Reference
        list.forEach(System.out::println);

    }
}
