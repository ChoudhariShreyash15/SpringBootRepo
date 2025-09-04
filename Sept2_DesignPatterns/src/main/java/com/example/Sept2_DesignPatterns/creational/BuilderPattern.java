package com.example.Sept2_DesignPatterns.creational;


class Animal
{
    private String name;
    private String color;
    private String type;

    public Animal(Builder builder)
    {
        this.name=builder.name;
        this.color=builder.color;
        this.type=builder.type;
    }

    public static class Builder
    {
        private String name;
        private String color;
        private String type;

        public Builder name(String name)
        {
            this.name=name;
            return this;
        }
        public Builder color(String color)
        {
            this.color=color;
            return this;
        }
        public Builder type(String type)
        {
            this.type=type;
            return this;
        }

        public Animal build()
        {
            return new Animal(this);
        }
    }

}
public class BuilderPattern {

    public static void main(String[] args) {
        Animal build = new Animal.Builder()
                .color("Red")
                .name("Tiger")
                .type("Carnvore")
                .build();
    }
}
