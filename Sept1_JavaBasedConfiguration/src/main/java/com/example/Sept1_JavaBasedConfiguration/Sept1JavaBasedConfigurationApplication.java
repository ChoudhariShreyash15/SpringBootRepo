package com.example.Sept1_JavaBasedConfiguration;

import com.example.Sept1_JavaBasedConfiguration.config.Config;
import com.example.Sept1_JavaBasedConfiguration.entity.Vehicle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Sept1JavaBasedConfigurationApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Vehicle bean = context.getBean(Vehicle.class);
		bean.engineType();
	}

}
