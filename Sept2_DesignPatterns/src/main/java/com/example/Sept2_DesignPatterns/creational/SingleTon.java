package com.example.Sept2_DesignPatterns.creational;

public class SingleTon {

    static SingleTon singleTon;

    private SingleTon()
    {

    }

    static void check()
    {
        if(singleTon==null)
        {
            singleTon=new SingleTon();
            System.out.println("Object created");
        }
        else
        {
            System.out.println("Object is already created");
        }
    }

    public static void main(String[] args) {
        check();
        check();
    }
}
