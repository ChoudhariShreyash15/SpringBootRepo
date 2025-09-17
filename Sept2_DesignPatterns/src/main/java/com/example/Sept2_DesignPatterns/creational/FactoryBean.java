package com.example.Sept2_DesignPatterns.creational;

class Person {
    private static Animals animals;

    public static void check() {
        animals = new Animals();
        System.out.println(animals);
    }
}

class Animals {
}

public class FactoryBean {
    public static void main(String[] args) {
        Animals animals = new Animals();
        System.out.println(animals);
        Person.check();
    }
}
