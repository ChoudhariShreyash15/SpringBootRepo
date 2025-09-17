package org.example.JavaBasedConfiguration.component;

import org.example.JavaBasedConfiguration.repo.Engine;

public class DieselEngine implements Engine {

    @Override
    public void info() {
        System.out.println("Diesel Engine");
    }
}