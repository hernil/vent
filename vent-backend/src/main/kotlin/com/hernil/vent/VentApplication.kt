package com.hernil.vent

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
@EnableAutoConfiguration(exclude = arrayOf(DataSourceAutoConfiguration::class))
class VentApplication {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(VentApplication::class.java, *args)
        }
    }
}