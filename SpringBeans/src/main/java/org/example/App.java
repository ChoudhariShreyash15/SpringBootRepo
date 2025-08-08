package org.example;

import org.example.JavaBasedConfiguration.component.Vehicle;
import org.example.JavaBasedConfiguration.configuration.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext ap = new AnnotationConfigApplicationContext(Config.class);
        Vehicle v = ap.getBean(Vehicle.class);
        v.engineType();
        ap.close();

//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Config.xml");
//        Vehicle vehicle=applicationContext.getBean(Vehicle.class);
//        vehicle.info();
    }
}
