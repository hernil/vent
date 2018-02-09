package com.hernil.vent.application.mastery.controllers

import com.hernil.vent.application.mastery.domain.Learner
import com.hernil.vent.application.mastery.domain.MasteryLearnerRepository
import com.hernil.vent.application.mastery.utils.fetchAllLearnersByUrl
import com.hernil.vent.application.mastery.utils.fetchOneLearnerByUrl
import org.springframework.web.bind.annotation.*
import java.net.URL

@RestController
@CrossOrigin(origins = arrayOf("http://localhost:3000"))
@RequestMapping("/masteryLearner")
class MasteryLearnerResource(val repository: MasteryLearnerRepository) {

    @GetMapping(value = "/all")
    fun getData() = repository.findAll()

    @GetMapping(value = "/hardAll")
    fun getAllData(): MutableList<Learner>? {
        println("Hello!")
        var url = "http://adapt2.sis.pitt.edu/aggregate2/GetContentLevels?grp=NorwaySpring2018&mod=user&sid=TEST&cid=352&usr=norway"
        var urls = mutableListOf<URL>()
        for (n in 1..15) {
            val s = url + n.toString()
            urls.add(URL(s))
        }
        repository.save(fetchAllLearnersByUrl(urls))
        return repository.findAll()
    }

    @GetMapping(value = "/{id}")
    fun getDataById(@PathVariable id: Long) = repository.findOne(id)

    @GetMapping(value = "/insert/{name}")
    fun insertData(@PathVariable name: String): List<Learner> {

        val learner = fetchOneLearnerByUrl(URL("http://adapt2.sis.pitt.edu/aggregate2/GetContentLevels?usr=norway1&grp=NorwaySpring2018&mod=user&sid=TEST&cid=352"))
        repository.save(learner)
        return repository.findAll()
    }
}

