package com.hernil.vent.application.vent.controllers

import com.hernil.vent.application.vent.domain.Course
import com.hernil.vent.application.vent.domain.CourseRepository
import com.hernil.vent.application.vent.domain.CourseUnit
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = arrayOf("http://localhost:3000"))
@RequestMapping("/course")
class CourseResource(val repository: CourseRepository) {

    @GetMapping(value = "/all")
    fun getData() = repository.findAll()

    @GetMapping(value = "/{id}")
    fun getDataById(@PathVariable id: String) = repository.findById(id)

    @PostMapping(value = "/insert")
    @ResponseStatus(HttpStatus.CREATED)
    fun insertData(@RequestBody course: Course): Course {
        repository.save(course)
        return course
    }

    @PostMapping(value = "/{id}/insert")
    @ResponseStatus(HttpStatus.CREATED)
    fun insertUnit(@PathVariable id: String, @RequestBody unit: CourseUnit): Course {
        val course = repository.findById(id)
        course.units.add(unit)
        repository.save(course)
        return course
    }
}