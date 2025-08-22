package com.example.Aug19_SpringBootApplication.config;

import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;

@Configuration
public class JpaCommonConfig {

    @Bean
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder(JpaVendorAdapter jpaVendorAdapter,
                                                                   JpaProperties jpaProperties) {
        return new EntityManagerFactoryBuilder(
                jpaVendorAdapter,
                jpaProperties.getProperties(),   // <- instead of emptyMap()
                null
        );
    }
}


