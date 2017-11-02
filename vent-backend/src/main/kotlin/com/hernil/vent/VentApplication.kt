package com.hernil.vent

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class VentApplication

fun main(args: Array<String>) {
    SpringApplication.run(VentApplication::class.java, *args)
}
