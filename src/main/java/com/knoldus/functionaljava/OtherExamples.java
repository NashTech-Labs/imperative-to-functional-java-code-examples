package com.knoldus.functionaljava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OtherExamples {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Sachin", "Laxman", "Sehwag", "Ganguly", "Dravid");
        example1(names);
    }


    // find whether an element exists in the list
    private static void example1(List<String> names) {

        //========= Imperative ==============
        boolean flag = false;
        for (String elem : names) {
            if (elem.length() == 5) {
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println("Element found");
        } else {
            System.out.println("Element not found");
        }

        //========= Functional ==============
        Optional<String> res = names.stream().filter(x -> x.length() == 5).findFirst();

        if (res.isPresent()) {
            System.out.println("Element found");
        } else {
            System.out.println("Element not found");
        }
    }

    // Transforming a list
    private static void example2(List<String> names) {

        //========= Imperative ==============
        final List<String> uppercaseNames = new ArrayList<String>();
        for (String name : names) {
            uppercaseNames.add(name.toUpperCase());
        }

        System.out.println(uppercaseNames);

        //========= Functional ==============
        List<String> uppercaseNamesFunc = names
                .stream().map(String::toUpperCase).collect(Collectors.toList());

        System.out.println(uppercaseNamesFunc);
    }

    // Finding elements
    private static void example3(List<String> names) {

        //========= Imperative ==============
        final List<String> startsWithN = new ArrayList<String>();
        for (String name : names) {
            if (name.startsWith("N")) {
                startsWithN.add(name);
            }
        }

        System.out.println(startsWithN);

        //========= Functional ==============
        final List<String> startsWithNFunc =
                names.stream()
                        .filter(name -> name.startsWith("N"))
                        .collect(Collectors.toList());

        System.out.println(startsWithNFunc);
    }

    // Finding elements multiple time
    private static void example4(List<String> names) {
        final Predicate<String> startsWithN = name -> name.startsWith("N");

        final List<String> startsWithNFunc =
                names.stream()
                        .filter(startsWithN)
                        .collect(Collectors.toList());

        System.out.println(startsWithNFunc);

        final List<String> startsWithNFunc1 =
                names.stream()
                        .filter(startsWithN)
                        .collect(Collectors.toList());

        System.out.println(startsWithNFunc1);
    }

    // Finding elements with multiple letters
    private static void example5(List<String> names) {
        final List<String> startsWithNFunc =
                names.stream()
                        .filter(checkIfStartsWith("N"))
                        .collect(Collectors.toList());

        System.out.println(startsWithNFunc);

        final List<String> startsWithNFunc1 =
                names.stream()
                        .filter(checkIfStartsWith("B"))
                        .collect(Collectors.toList());

        System.out.println(startsWithNFunc1);
    }

    private static Predicate<String> checkIfStartsWith(final String letter) {
        return name -> name.startsWith(letter);
    }


    // Finding elements with multiple letters, more refactoring
    private static void example6(List<String> names) {
        final Function<String, Predicate<String>> startsWithLetter =
                (String letter) -> {
                    Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
                    return checkStarts;
                };

       /* final Function<String, Predicate<String>> startsWithLetter =
                letter -> name -> name.startsWith(letter);*/


        final List<String> startsWithNFunc =
                names.stream()
                        .filter(startsWithLetter.apply("N"))
                        .collect(Collectors.toList());

        final List<String> startsWithNFunc1 =
                names.stream()
                        .filter(startsWithLetter.apply("B"))
                        .collect(Collectors.toList());
    }


    // Picking an element
    private static void example7(List<String> names, final String letter) {

        //========= Imperative ==============
        String foundName = null;
        for (String name : names) {
            if (name.startsWith(letter)) {
                foundName = name;
                break;
            }
        }

        if (foundName != null) {
            System.out.println(foundName);
        } else {
            System.out.println("No name found");
        }

        //========= Functional ==============
        final Optional<String> foundName1 =
                names.stream()
                        .filter(name -> name.startsWith(letter))
                        .findFirst();
        System.out.println(String.format("A name starting with %s: %s",
                letter, foundName1.orElse("No name found")));
    }

    // Find length of all characters
    private static void example8(List<String> names) {

        //========= Imperative ==============
        int sum = 0;
        for (String elem : names) {
            sum += elem.length();
        }

        System.out.println(sum);

        //========= Functional ==============
        System.out.println("Total number of characters in all names: " +
                names.stream().mapToInt(String::length).sum());
    }


    // Join the elements
    private static void example9(List<String> names) {

        //========= Imperative ==============
        for (int i = 0; i < names.size() - 1; i++) {
            System.out.println(names.get(i) + ",");
        }

        if (names.size() > 0)
            System.out.println(names.get(names.size() - 1));

        //========= Functional ==============

//1
        System.out.println(String.join(", ", names));
//2
        System.out.println(
                names.stream()
                        .map(String::toUpperCase)
                        .collect(Collectors.joining(", ")));
    }
}
