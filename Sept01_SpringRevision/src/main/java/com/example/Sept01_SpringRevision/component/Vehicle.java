package com.example.Sept01_SpringRevision.component;

import com.example.Sept01_SpringRevision.repo.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Vehicle {
    private Engine engine;

    @Autowired
    @Qualifier("Diesel")
    public void setEngine(Engine engine){
        this.engine=engine;
    }

    public void engineType(Engine engine){
        engine.info();
    }
}
