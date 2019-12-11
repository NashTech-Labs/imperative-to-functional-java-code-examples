package com.knoldus.functionaljava.lambda;

import java.util.List;
import java.util.function.Supplier;

public class MethodReference {

    // There are 5 different types of method references

    // 1. Method Reference of an Instance Method
    private void instanceMethod(List<String> names) {
        names.stream().map(name -> name.toUpperCase());

        // Using method reference
        names.stream().map(String::toUpperCase);
    }


    // 2. Method Reference to a Method on Another Instance
    private void anotherMethod(List<String> names) {
        names.forEach(name -> System.out.println(name));

        // Using method reference
        names.forEach(System.out::println);
    }


    // 3. Method Reference to a static Method
    private void method(String str) {
        str.chars().filter(ch -> Character.isDigit(ch));

        // Using method reference
        str.chars().filter(Character::isDigit);
    }


    // 4. Method Reference of a Method That Takes Parameters
    private void methodTakeparameter(List<Person> people) {
        people.stream().sorted((person1, person2) -> person1.ageDifference(person2));

        // Using method reference
        people.stream().sorted(Person::ageDifference);
    }


    // 5. Constructor Reference
    private void constructorReference() {
        Supplier<Person> supplier = () -> new Person();

        // Using method reference
        Supplier<Person> supplier1 = Person::new;
    }
}


class Person {
    private final String name;
    private final int age;

    public Person() {
        name = "Rishi";
        age = 30;
    }

    public Person(final String theName, final int theAge) {
        name = theName;
        age = theAge;
    }

    public int ageDifference(final Person other) {
        return age - other.age;
    }
}
