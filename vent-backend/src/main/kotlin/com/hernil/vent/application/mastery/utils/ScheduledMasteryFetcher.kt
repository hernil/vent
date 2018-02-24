package com.hernil.vent.application.mastery.utils

import com.hernil.vent.application.mastery.domain.MasteryLearnerRepository
import com.hernil.vent.application.protus.domain.LearnersRepository
import com.hernil.vent.application.utils.logger
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.net.URL

@Component
class ScheduledMasteryFetcher(val repository: MasteryLearnerRepository, val protusRepo: LearnersRepository) {

    val log by logger()

    //@Scheduled(fixedDelay = 300000)
    fun task() {
        log.info("Started scheduled fetching of mastery data")
        var url = "http://adapt2.sis.pitt.edu/aggregate2/GetContentLevels?grp=NorwaySpring2018&mod=user&sid=TEST&cid=352&usr="
        val urls = protusRepo.findAll()
                .map {
                    log.debug("masteryID: ${it.masteryId}")
                    URL(url + it.masteryId) }

        repository.save(fetchAllLearnersByUrl(urls))
        log.info("Mastery database succesfully updated")
    }

    fun test() {
        log.info("testlog")
    }
}