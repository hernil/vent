package com.hernil.vent.application.vent.controllers

import com.hernil.vent.application.vent.domain.Data
import com.hernil.vent.application.vent.domain.DataRepository
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = arrayOf("http://localhost:3000"))
@RequestMapping("/data")
class DataResource(val repository: DataRepository) {

    @GetMapping(value = "/all")
    fun getData() = repository.findAll()

    @GetMapping(value = "/{id}")
    fun getDataById(@PathVariable id: Long) = repository.findOne(id)

    @GetMapping(value = "/insert/{name}")
    fun insertData(@PathVariable name: String,
                   @RequestParam(value = "data", defaultValue = "") data: String): List<Data> {
        //val a = "7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6"
        val b: List<Double> = data.split(',').map { it.toDouble() }
        val d = Data(name, b)
        repository.save(d)
        return repository.findAll()
    }
}

