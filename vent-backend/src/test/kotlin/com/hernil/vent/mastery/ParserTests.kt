package com.hernil.vent.mastery

import com.hernil.vent.application.mastery.utils.MasteryParser
import org.json.JSONObject
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import java.io.File
import java.io.InputStream
import java.net.URL

class ParserTests {

    val masteryEndpoint: String = "http://adapt2.sis.pitt.edu/aggregate2/" +
            "GetContentLevels?grp=NorwaySpring2018&mod=user&sid=TEST&cid=352&usr="

    @Test
    fun parseKnownGoodSourceData() {
        val inputStream: InputStream = File("src/test/kotlin/com/hernil/vent/mastery/testdata/example-input.json").inputStream()
        val inputString = inputStream.bufferedReader().use { it.readText() }
        val localInputJson = JSONObject(inputString)
        val learner = MasteryParser(localInputJson.getJSONObject("learner")).parsedData
        assertNotNull(learner)
        assertEquals(localInputJson.getJSONObject("learner").getString("id"), learner.id)
        assertEquals(localInputJson.getJSONObject("learner").getJSONObject("state").
                getJSONObject("topics").getJSONObject("ArrayLists").
                getJSONObject("sequencing").getDouble("Challenges"),
                learner.topics.find { it.description == "ArrayLists"}!!
                        .sequencing.find { it.type == "Challenges" }!!.value)
    }

    @Test
    fun parseRemoteAPIData() {
        val inputJson = JSONObject(URL(masteryEndpoint + "norway3").readText())
        val learner = MasteryParser(inputJson.getJSONObject("learner")).parsedData
        assertNotNull(learner)
        assertEquals(inputJson.getJSONObject("learner").getString("id"), learner.id)
        assertEquals(inputJson.getJSONObject("learner").getJSONObject("state").
                getJSONObject("topics").getJSONObject("ArrayLists").
                getJSONObject("sequencing").getDouble("Challenges"),
                learner.topics.find { it.description == "ArrayLists"}
                        ?.sequencing?.find { it.type == "Challenges" }?.value)
    }

}