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
        basePackages = "com.example.Aug19_SpringBootApplication.mysqlRepo",
        entityManagerFactoryRef = "mysqlEmf",
        transactionManagerRef = "mysqlTxManager"
)
public class MysqlConfig {

    @Bean(name = "mysqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mysqlEmf")
    public LocalContainerEntityManagerFactoryBean mysqlEmf(
            EntityManagerFactoryBuilder builder,
            @Qualifier("mysqlDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.Aug19_SpringBootApplication.entities")
                .persistenceUnit("mysqlPU")
                .build();
    }

    @Bean(name = "mysqlTxManager")
    public PlatformTransactionManager mysqlTxManager(
            @Qualifier("mysqlEmf") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
