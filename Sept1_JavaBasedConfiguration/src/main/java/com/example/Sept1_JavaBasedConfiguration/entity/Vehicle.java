package com.example.Sept1_JavaBasedConfiguration.entity;

import com.example.Sept1_JavaBasedConfiguration.repo.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Vehicle {
    private Engine engine;

    @Autowired
    @Qualifier("getPetrol")
    public void setEngine(Engine engine){
        this.engine=engine;
    }

    public void engineType(){
        engine.engineType();
    }
}
