package org.example.JavaBasedConfiguration.component;

import org.example.JavaBasedConfiguration.repo.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Vehicle {

    @Autowired
    private Engine engine;

    @Qualifier("diesel")
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void engineType(){
        engine.info();
//        petrolEngine.info();
//        dieselEngine.info();
    }

//    private final Engine petrolEngine;
//    private final Engine dieselEngine;

//    @Autowired
//    public Vehicle( Engine engine)
//    {
////        this.petrolEngine=petrolEngine;
////        this.dieselEngine=dieselEngine;
//        this.engine=engine;
//    }
}