package com.example.Sept1_JavaBasedConfiguration.config;

import com.example.Sept1_JavaBasedConfiguration.entity.Diesel;
import com.example.Sept1_JavaBasedConfiguration.entity.Petrol;
import com.example.Sept1_JavaBasedConfiguration.entity.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Diesel getDiesel(){
        return new Diesel();
    }

    @Bean
    public Petrol getPetrol(){
        return new Petrol();
    }

    @Bean
    public Vehicle getVehicle(){
        return new Vehicle();
    }
}
