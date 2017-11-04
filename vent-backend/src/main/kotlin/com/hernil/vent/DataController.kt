package com.hernil.vent

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/data")
class DataResource(val repository: DataRepository) {

    @GetMapping(value = "/all")
    fun getData() = repository.findAll()

    @GetMapping(value = "/{id}")
    fun getDataById(@PathVariable id: Long) = repository.findById(id)

    @GetMapping(value = "/insert/{name}")
    fun insertData(@RequestParam(value = "name", defaultValue = "") name: String): List<Data> {
        val d = Data(name)
        repository.save(d)
        return repository.findAll()
    }
}
