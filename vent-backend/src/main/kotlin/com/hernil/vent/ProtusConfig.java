package com.hernil.vent;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

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
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "protusEntityManagerFactory",
        transactionManagerRef = "protusTransactionManager",
        basePackages = { "com.hernil.vent.protus" })
public class ProtusConfig {

    @Bean(name = "protusDataSource")
    @ConfigurationProperties(prefix="spring.datasource.protus")
    public DataSource protusDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "protusEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean protusEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("protusDataSource") DataSource protusDataSource) {
        return builder
                .dataSource(protusDataSource)
                .packages("com.hernil.vent.protus")
                .persistenceUnit("protus")
                .build();
    }

    @Bean(name = "protusTransactionManager")
    public PlatformTransactionManager protusTransactionManager(
            @Qualifier("protusEntityManagerFactory") EntityManagerFactory protusEntityManagerFactory) {
        return new JpaTransactionManager(protusEntityManagerFactory);
    }

}