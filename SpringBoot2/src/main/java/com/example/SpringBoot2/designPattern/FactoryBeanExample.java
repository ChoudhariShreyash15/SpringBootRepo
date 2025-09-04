package com.example.SpringBoot2.designPattern;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


class PersonBean extends AbstractFactoryBean<Person>
{


    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    @Override
    protected Person createInstance() throws Exception {
        return new Person("Mahesh",21);
    }
}

@Configuration
class PersonConfig
{
    @Bean
    public PersonBean person()
    {
        return new PersonBean();
    }

}
public class FactoryBeanExample {
    public static void main(String[] args) {

    }
}
