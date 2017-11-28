package com.hernil.vent

import org.springframework.beans.factory.annotation.Qualifier

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.core.JdbcTemplate

import javax.sql.DataSource

@Configuration
class VentApplicationConfig {

    @Bean(name = arrayOf("jdbcPrimaryTemplate"))
    fun jdbcPrimaryTemplate(@Qualifier(value = "primaryDataSource") primaryDataSource: DataSource): JdbcTemplate =
            JdbcTemplate(primaryDataSource)

    @Bean(name = arrayOf("jdbcSecondaryTemplate"))
    fun jdbcSecondaryTemplate(@Qualifier(value = "secondaryDataSource") secondaryDataSource: DataSource): JdbcTemplate =
            JdbcTemplate(secondaryDataSource)

    @Bean(name = arrayOf("primaryDataSource"))
    @Primary
    @ConfigurationProperties(prefix = "datasource.vent")
    fun primaryDataSource(): DataSource = DataSourceBuilder.create().build()

    @Bean(name = arrayOf("secondaryDataSource"))
    @ConfigurationProperties(prefix = "datasource.protus")
    fun secondaryDataSource(): DataSource = DataSourceBuilder.create().build()
}