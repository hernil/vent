package com.hernil.vent.application.mastery.controllers

import com.hernil.vent.application.mastery.domain.Learner
import com.hernil.vent.application.mastery.domain.MasteryLearnerRepository
import com.hernil.vent.application.mastery.utils.fetchAllLearnersByUrl
import com.hernil.vent.application.mastery.utils.fetchOneLearnerByUrl
import com.hernil.vent.application.protus.domain.LearnersRepository
import com.hernil.vent.application.utils.logger
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.*
import java.net.URL

@RestController
@CrossOrigin(origins = arrayOf("http://localhost:3000"))
@RequestMapping("/masteryLearner")
class MasteryLearnerResource(val repository: MasteryLearnerRepository, val protusRepo: LearnersRepository) {

    val log by logger()

    @Value("\${mastery_endpoint}")
    val masteryEndpoint: String = ""

    @GetMapping(value = "/all")
    fun getUsers() = repository.findAll()

    @GetMapping(value = "/{id}")
    fun getUserById(@PathVariable id: String) = repository.findById(id)

    @GetMapping(value = "/update/{id}")
    fun updateUser(@PathVariable id: String): Learner {

        val updatedLearner = fetchOneLearnerByUrl(URL(masteryEndpoint + id))
        try {
            val learner = repository.findById(updatedLearner.id)
            log.info("Updating mastery user: ${learner.id}")
            learner.topics = updatedLearner.topics
            learner.activityTopic = updatedLearner.activityTopic
        }catch (e: NullPointerException) {
            log.info("User ${updatedLearner.id} is not in the database.")
            repository.save(updatedLearner)
            log.info("Created user ${updatedLearner.id} in the database.")
        }
        return updatedLearner
    }
}

