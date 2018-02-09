package com.hernil.vent.application.mastery;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "masteryEntityManagerFactory",
        transactionManagerRef = "masteryTransactionManager",
        basePackages = { "com.hernil.vent.application.mastery" })
public class MasteryDatasourceConfig {

    @Bean(name = "masteryDataSource")
    @ConfigurationProperties(prefix="spring.datasource.mastery")
    public DataSource masteryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "masteryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean masteryEntityManagerFactory(
            EntityManagerFactoryBuilder builder, JpaProperties jpaProperties,
            @Qualifier("masteryDataSource") DataSource masteryDataSource) {
        return builder
                .dataSource(masteryDataSource)
                .packages("com.hernil.vent.application.mastery")
                .persistenceUnit("mastery")
                .properties(jpaProperties.getHibernateProperties(masteryDataSource))
                .build();
    }

    @Bean(name = "masteryTransactionManager")
    public PlatformTransactionManager masteryTransactionManager(
            @Qualifier("masteryEntityManagerFactory") EntityManagerFactory masteryEntityManagerFactory) {
        return new JpaTransactionManager(masteryEntityManagerFactory);
    }

}