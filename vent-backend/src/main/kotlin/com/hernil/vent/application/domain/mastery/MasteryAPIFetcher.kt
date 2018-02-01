package com.hernil.vent.application.domain.mastery

import com.hernil.vent.application.domain.mastery.parsers.MasteryParser
import org.json.JSONObject
import java.net.URL


fun fetchOneLearnerByUrl(url: URL): Learner {
    val json = JSONObject(url.readText())
    val learner = MasteryParser(json.getJSONObject("learner")).parsedData
    return learner
}

fun fetchAllLearnersByUrl(urls: List<URL>): MutableList<Learner> {
    val learners = mutableListOf<Learner>()
    urls.forEach { url ->
        learners.add(fetchOneLearnerByUrl(url))
    }
    return learners
}

fun fetchAllLearnersByUsername(usernames: List<String>, url: URL): MutableList<Learner> {
    val learners = mutableListOf<Learner>()
    usernames.forEach { username ->
        learners.add(fetchOneLearnerByUrl(url))
    }
    return learners
}
