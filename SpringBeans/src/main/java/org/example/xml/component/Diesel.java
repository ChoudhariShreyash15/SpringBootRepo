package org.example.xml.component;

import org.example.xml.repo.Engine1;

public class Diesel implements Engine1 {
    @Override
    public void engineType() {
        System.out.println("It's a Diesel Engine");
    }
}
