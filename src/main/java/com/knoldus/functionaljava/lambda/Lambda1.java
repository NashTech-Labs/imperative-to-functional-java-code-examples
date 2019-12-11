package com.knoldus.functionaljava.lambda;

// Implement the show function and call that

interface Parent {
    void show();
}

// =====================Imperative way-1 ========================


/*
class Child implements Parent {
    public void show() {
        System.out.println("I am the imperative way 1");
    }
}

public class Lambda1 {
    public static void main(String[] args) {
        Parent p = new Child();
        p.show();
    }
}
*/


// =====================Imperative way-2 ========================

/*
public class Lambda1 {
    public static void main(String[] args) {
        Parent p = new Parent() {
            @Override
            public void show() {
                System.out.println("I am the imperative way 2 ");
            }
        };
        p.show();
    }
}
*/


// =====================Functional way ==========================

public class Lambda1 {
    public static void main(String[] args) {
        Parent p = () -> System.out.println("I am the functional way");
        p.show();
    }
}