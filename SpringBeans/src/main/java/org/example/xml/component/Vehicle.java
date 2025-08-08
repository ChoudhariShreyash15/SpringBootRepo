package org.example.xml.component;

import org.example.xml.repo.Engine1;
import org.springframework.beans.factory.annotation.Autowired;

public class Vehicle {
    private Engine1 engine1;

    @Autowired
    public void setEngine1(Engine1 engine1) {
        this.engine1 = engine1;
    }
    public void info(){
        engine1.engineType();
    }
}
