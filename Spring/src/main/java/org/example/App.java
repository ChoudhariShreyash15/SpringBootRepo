package org.example;

import org.example.components.Principal;
import org.example.configuration.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext c = new AnnotationConfigApplicationContext(SpringConfig.class);
        Principal p = c.getBean(Principal.class);
        p.teacher();
    }
}