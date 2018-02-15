package com.hernil.vent.application.protus.controllers

import com.hernil.vent.application.protus.domain.LearnersRepository
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = arrayOf("http://localhost:3000"))
@RequestMapping("/protus/student")
class ProtusStudentController(val repository: LearnersRepository) {

    @GetMapping(value = "/all")
    fun getData() = repository.findAll()

    @GetMapping(value = "/{id}")
    fun getDataById(@PathVariable id: Int) = repository.findOne(id)
}