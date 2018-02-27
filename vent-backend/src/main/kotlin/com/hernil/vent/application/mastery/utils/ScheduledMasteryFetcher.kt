package com.hernil.vent.application.mastery.utils

import com.hernil.vent.application.mastery.domain.MasteryLearnerRepository
import com.hernil.vent.application.protus.domain.LearnersRepository
import com.hernil.vent.application.utils.logger
import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.net.URL

@Component
class ScheduledMasteryFetcher(val repository: MasteryLearnerRepository, val protusRepo: LearnersRepository) {

    val log by logger()

    @Value("\${mastery_endpoint}")
    val masteryEndpoint: String = ""

    //@Scheduled(fixedDelay = 300000)
    fun task() {
        log.info("Started scheduled fetching of mastery data")
        val urls = protusRepo.findAll()
                .map {
                    log.debug("masteryID: ${it.masteryId}")
                    URL(masteryEndpoint + it.masteryId) }

        val learners = fetchAllLearnersByUrl(urls)
        learners.forEach { updatedLearner ->
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
        }
        log.info("Mastery database succesfully updated")
    }

}