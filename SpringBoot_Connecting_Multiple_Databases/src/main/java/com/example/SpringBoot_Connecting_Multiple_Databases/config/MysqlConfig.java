package com.example.SpringBoot_Connecting_Multiple_Databases.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "getMysqlFactoryBean",
transactionManagerRef = "getMysqlTransaction",
basePackages = "com.example.SpringBoot_Connecting_Multiple_Databases.mysqlRepo")
public class MysqlConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.mysql.datasource")
    public DataSourceProperties getMysqldataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    public DataSource getMysqldatasource(@Qualifier("getMysqldataSourceProperties") DataSourceProperties dataSourceProperties){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        driverManagerDataSource.setUrl(dataSourceProperties.getUrl());
        driverManagerDataSource.setUsername(dataSourceProperties.getUsername());
        driverManagerDataSource.setPassword(dataSourceProperties.getPassword());

        return  driverManagerDataSource;
    }

    @Bean
    public JpaVendorAdapter getMysqlJpaVendorAdaptor(){
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(true);

        return hibernateJpaVendorAdapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getMysqlFactoryBean(@Qualifier("getMysqlJpaVendorAdaptor") JpaVendorAdapter jpaVendorAdapter, @Qualifier("getMysqldatasource") DataSource dataSource){
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setPackagesToScan("com.example.SpringBoot_Connecting_Multiple_Databases.mysqlEntity");
        bean.setDataSource(dataSource);
        bean.setJpaVendorAdapter(jpaVendorAdapter);

        return bean;
    }

    @Bean
    public PlatformTransactionManager getMysqlTransaction(@Qualifier("getMysqlFactoryBean") LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean){
        assert localContainerEntityManagerFactoryBean.getObject() != null;

        return new JpaTransactionManager(localContainerEntityManagerFactoryBean.getObject());
    }

}
