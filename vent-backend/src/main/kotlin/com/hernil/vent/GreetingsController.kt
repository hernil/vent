package com.hernil.vent

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    val counter = AtomicLong()

    @CrossOrigin(origins = arrayOf("http://localhost:3000"))
    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Greeting(counter.incrementAndGet(), "Hello this is, $name")

    @CrossOrigin(origins = arrayOf("http://localhost:3000"))
    @GetMapping("/data")
    fun data() =
            Data()

}