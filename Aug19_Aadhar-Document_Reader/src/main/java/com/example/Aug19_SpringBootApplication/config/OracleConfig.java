package com.example.Aug19_SpringBootApplication.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.Aug19_SpringBootApplication.oracleRepo",
        entityManagerFactoryRef = "oracleEmf",
        transactionManagerRef = "oracleTxManager"
)
public class OracleConfig {

    @Bean(name = "oracleDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.oracle")
    public DataSource oracleDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "oracleEmf")
    public LocalContainerEntityManagerFactoryBean oracleEmf(
            EntityManagerFactoryBuilder builder,
            @Qualifier("oracleDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.Aug19_SpringBootApplication.entities")
                .persistenceUnit("oraclePU")
                .build();
    }

    @Bean(name = "oracleTxManager")
    public PlatformTransactionManager oracleTxManager(
            @Qualifier("oracleEmf") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
