package org.example.components;

import org.example.repo.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Principal {
    @Autowired
    private School s; //property
    public void teacher(){
        s.name();
        if (s.name().equals("Priyanka")){
            System.out.println("Hi " + s.name() + ". Nice to meet you!");
        }
        else {
            System.out.println("Hi Bhadwya");
        }
    }
}
