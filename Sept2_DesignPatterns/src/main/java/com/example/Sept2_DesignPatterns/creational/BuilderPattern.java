package com.example.Sept2_DesignPatterns.creational;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
class Animal {
    private String name;
    private String color;
    private String type;

    public Animal(Builder builder) {
        this.name = name;
        this.color = color;
        this.type = type;
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        Animals build = Animals.builder().name("Dog").color("Black").type("Labrador").build();
        System.out.println(build);
    }
}