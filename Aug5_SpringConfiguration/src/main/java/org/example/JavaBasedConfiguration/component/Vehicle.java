package org.example.JavaBasedConfiguration.component;

import org.example.JavaBasedConfiguration.repo.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Vehicle {

//    private final Engine petrolEngine;
//    private final Engine dieselEngine;
    private Engine engine;

    @Autowired
    @Qualifier("diesel")
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

//    @Autowired
//    public Vehicle( Engine engine)
//    {
////        this.petrolEngine=petrolEngine;
////        this.dieselEngine=dieselEngine;
//        this.engine=engine;
//    }

    public void engineType(){
        engine.info();
//        petrolEngine.info();
//        dieselEngine.info();
    }
}
