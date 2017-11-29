package com.hernil.vent.application.controllers

import com.hernil.vent.protus.domain.LearnersRepository
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = arrayOf("http://localhost:3000"))
@RequestMapping("/student")
class StudentController(val repository: LearnersRepository) {

    @GetMapping(value = "/all")
    fun getData() = repository.findAll()

    @GetMapping(value = "/{id}")
    fun getDataById(@PathVariable id: Long) = repository.findById(id)
}