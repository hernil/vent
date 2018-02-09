package com.hernil.vent.application.vent.controllers

import com.hernil.vent.application.vent.domain.CourseRepository
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = arrayOf("http://localhost:3000"))
@RequestMapping("/course")
class CourseResource(val repository: CourseRepository) {

    @GetMapping(value = "/all")
    fun getData() = repository.findAll()

    @GetMapping(value = "/{id}")
    fun getDataById(@PathVariable id: Long) = repository.findOne(id)
}