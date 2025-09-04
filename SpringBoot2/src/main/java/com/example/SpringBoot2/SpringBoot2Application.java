package com.example.SpringBoot2;

import com.example.SpringBoot2.designPattern.Person;
import com.example.SpringBoot2.entity.Eidiko;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBoot2Application {

	public static void main(String[] args) {
		ApplicationContext run = SpringApplication.run(SpringBoot2Application.class, args);
		SpringBoot2Application bean = run.getBean(SpringBoot2Application.class);
		SpringBoot2Application bean1 = run.getBean(SpringBoot2Application.class);
		System.out.println(bean1==bean);
		Eidiko branch = Eidiko.builder().
				empId(5).
				empName("Hrishikesh").
				empSalary(20000).
				build();

		Person person = (Person) run.getBean("person");
		Person bean2 = run.getBean(Person.class);
		System.out.println(person);
		System.out.println(person==bean2);

//		Animal animal = new Animal("Red", "Tiger", null);
	}
}


@AllArgsConstructor
class Animal
{
	String name;
	String color;
	String population;
}
