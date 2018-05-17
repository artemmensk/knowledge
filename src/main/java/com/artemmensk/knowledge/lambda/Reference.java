package com.artemmensk.knowledge.lambda;

import lombok.ToString;

public class Reference {
    public static void main(String[] args) {
        createPerson(Person::new);              // constructor reference
        createPerson(Person::createDefault);    // static method reference
        createPerson(new Person()::createCopy); // instance method reference
    }

    private static void createPerson(PersonFactory factory) {
        System.out.println(factory.create());
    }
}

@FunctionalInterface
interface PersonFactory {
    Person create();
}

@ToString
class Person {
    static Person createDefault() {
        return new Person();
    }

    Person createCopy() {
        return new Person();
    }
}
