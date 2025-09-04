package com.example.SpringBoot2.designPattern;


import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
class Employee
{
    String name;
    int age;

    public Employee(Builder builder)
    {
        this.name=builder.name;
        this.age=builder.age;
    }

    public static class Builder
    {
        private String name;
        private int age;

        public Builder name(String name)
        {
            this.name=name;
            return this;
        }

        public Builder age(int age)
        {
            this.age=age;
            return this;
        }

        public Employee build()
        {
            return new Employee(this);
        }
    }
}
interface Iterator<T>
{
    boolean hasNext();
    T next();
}

interface Iterable<T>
{
    Iterator<T> createIterator();
}

public class IteratorExample implements Iterable<String> {

    String[]name={"Mahesh","Suresh","Kishore"};
    public static void main(String[] args) {
        String s = new IteratorExample().name[0];
        String[]str={"a","b","c"};
        String s1 = str[0];
        String s2 = str[1];
//        Iterator<String>iterator= Arrays.stream(name).iterator();
//
//        while(iterator.hasNext())
//        {
//            System.out.println(iterator.next());
//        }

        Iterator<String> iterator = new IteratorExample().createIterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
//        Employee age = new Employee.EmployeeBuilder()
//                .name("")
//                .age(21)
//                .build();
        Employee mahesh = new Employee.Builder()
                .name("Mahesh")
                .age(21)
                .build();
        System.out.println(mahesh);
    }

    @Override
    public Iterator<String> createIterator() {
        return new Iterator<String>() {
            int index=0;
            @Override
            public boolean hasNext() {
                return index<new IteratorExample().name.length;
            }

            @Override
            public String next() {
                return new IteratorExample().name[index++];
            }
        };
    }
}
