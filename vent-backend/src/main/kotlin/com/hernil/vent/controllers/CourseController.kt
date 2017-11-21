package com.hernil.vent.controllers

import com.hernil.vent.services.CourseRepository
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = arrayOf("http://localhost:3000"))
@RequestMapping("/course")
class CourseResource(val repository: CourseRepository) {

    @GetMapping(value = "/all")
    fun getData() = repository.findAll()

    @GetMapping(value = "/{id}")
    fun getDataById(@PathVariable id: Long) = repository.findById(id)
}