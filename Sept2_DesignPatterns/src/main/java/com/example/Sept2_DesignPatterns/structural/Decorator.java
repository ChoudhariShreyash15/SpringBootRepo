package com.example.Sept2_DesignPatterns.structural;

interface Coffee {
    String getDescription();
    Integer getCost();
}

class SimpleCoffee implements Coffee {
    public String getDescription(){
        return "Simple Coffee";
    }
    public Integer getCost(){
        return 5;
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee){
        this.coffee=coffee;
    }

    public String getDescription(){
        return coffee.getDescription();
    }

    public Integer getCost(){
        return coffee.getCost();
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee){
        super(coffee);
    }

    public String getDescription(){
        return super.getDescription() + " + Milk ";
    }

    public Integer getCost(){
        return super.getCost() + 5;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee){
        super(coffee);
    }

    public String getDescription(){
        return super.getDescription() + "+ Sugar ";
    }

    public Integer getCost(){
        return super.getCost() + 5;
    }
}

public class Decorator{
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " -> Rs. " + coffee.getCost());

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " -> Rs. " + coffee.getCost());

        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " -> Rs. " + coffee.getCost());
    }
}
