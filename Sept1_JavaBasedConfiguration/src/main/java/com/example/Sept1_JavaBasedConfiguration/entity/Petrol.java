package com.example.Sept1_JavaBasedConfiguration.entity;

import com.example.Sept1_JavaBasedConfiguration.repo.Engine;

public class Petrol implements Engine {
    @Override
    public void engineType() {
        System.out.println("Petrol");
    }
}
