package org.example.xml.component;

import org.example.xml.repo.Engine1;

public class Petrol implements Engine1 {
    @Override
    public void engineType() {
        System.out.println("It's an Petrol Engine");
    }
}
