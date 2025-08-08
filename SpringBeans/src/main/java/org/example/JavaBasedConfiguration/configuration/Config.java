package org.example.JavaBasedConfiguration.configuration;

import org.example.JavaBasedConfiguration.component.DieselEngine;
import org.example.JavaBasedConfiguration.repo.Engine;
import org.example.JavaBasedConfiguration.component.PetrolEngine;
import org.example.JavaBasedConfiguration.component.Vehicle;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
public class Config implements InitializingBean, DisposableBean {

//    @Bean(initMethod = "initialized", destroyMethod = "readyDestroyed")
//@Qualifier("petrol") Engine petrolEngine,@Qualifier("diesel") Engine dieselEngine
    @Bean
    public Vehicle getVehicle(){ return new Vehicle(); }

    @Bean(name = "petrol")
    public PetrolEngine getPetrol(){
        return new PetrolEngine();
    }

    @Bean(name = "diesel")
    public DieselEngine getDiesel(){
        return new DieselEngine();
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Beans ready to Initialize");
    }

    @PostConstruct
    public void initialized(){
        System.out.println("Beans are created using post");
    }


    @PreDestroy
    public void readyDestroyed(){
        System.out.println("Beans are Destroyed using pre");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Beans Destroyed");
    }
}
