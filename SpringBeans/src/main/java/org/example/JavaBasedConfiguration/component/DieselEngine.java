package org.example.JavaBasedConfiguration.component;

import org.example.JavaBasedConfiguration.repo.Engine;
import org.springframework.context.annotation.Primary;

public class DieselEngine implements Engine {

    @Override
    public void info() {
        System.out.println("Diesel Engine");
    }
}
