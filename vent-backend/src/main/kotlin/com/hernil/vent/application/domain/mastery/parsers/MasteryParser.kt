package com.hernil.vent.application.domain.mastery.parsers

import com.hernil.vent.application.domain.mastery.*
import com.hernil.vent.application.utils.logger
import org.json.JSONObject

class MasteryParser(inputData: JSONObject) {

    val log by logger()

    val parsedData: Learner = Learner(
            id = inputData.getString("id"),
            name = inputData.getString("name"),
            topics = generateTopics(inputData.getJSONObject("state").getJSONObject("topics")),
            activityTopic = generateActivities(inputData.getJSONObject("state").getJSONObject("activities")))

    fun generateTopics(topics: JSONObject): MutableList<Topic> {
        val topicList: MutableList<Topic> = mutableListOf()

        fun generateSequencingValues(sequencingValuesContainer: JSONObject): MutableList<TopicSequencing> {
            val sequencing: MutableList<TopicSequencing> = mutableListOf()
            log.debug("Parsing sequencing values for: " + sequencingValuesContainer)
            sequencingValuesContainer.keys().forEach { activityType ->
                log.debug("ActivityType: " + activityType)
                sequencing.add(
                        TopicSequencing(
                                type = activityType,
                                value = sequencingValuesContainer.getDouble(activityType)))
            }
            return sequencing
        }

        fun generateValues(valuesContainer: JSONObject): MutableList<TopicValue> {
            val values: MutableList<TopicValue> = mutableListOf()

            valuesContainer.keys().forEach { activityType ->
                log.debug("Parsing topic values for: " + activityType)
                values.add(
                        TopicValue(
                                type = activityType as String,
                                knowledge = valuesContainer.getJSONObject(activityType).getDouble("k"),
                                progress = valuesContainer.getJSONObject(activityType).getInt("p") == 1))
            }
            return values
        }

        topics.keys().forEach {topicName ->
            log.debug("Creating topic object for: " + topicName)
            val topic = topics.getJSONObject(topicName)
            val overall_knowledge = topic.getJSONObject("overall").getDouble("k")
            val overall_progress = topic.getJSONObject("overall").getInt("p") == 1

            val sequencing = generateSequencingValues(topic.getJSONObject("sequencing"))
            val valueList: MutableList<TopicValue> = generateValues(topic.getJSONObject("values"))

            topicList.add(
                    Topic(
                            description = topicName as String,
                            values = valueList, sequencing = sequencing,
                            overallKnowledge = overall_knowledge,
                            overallProgress = overall_progress
                    )
            )

        }

        return topicList
    }

    fun generateActivities(inputData: JSONObject): MutableList<ActivityTopic> {
        val activityTopicList: MutableList<ActivityTopic> = mutableListOf()

        fun generateTopicActivities(topic: String): MutableList<Activity> {
            log.debug("Generating activities for topic: " + topic)
            var topicActivities = inputData.getJSONObject(topic)
            var activitiesList: MutableList<Activity> = mutableListOf()
            topicActivities.keys().forEach { type ->
                log.debug("Looping through: " + type)
                val activities = topicActivities.getJSONObject(type)

                activities.keys().forEach { activity ->
                    log.debug("Generating acitivty: " + activity)
                    val activityObject = activities.getJSONObject(activity)
                    val activityValues = activityObject.getJSONObject("values")
                    val values = ActivityValue(
                            knowledge = activityValues.getDouble("k"),
                            progress = activityValues.getInt("p") == 1,
                            a = activityValues.getDouble("a"),
                            s = activityValues.getDouble("s"),
                            t = activityValues.getDouble("t"),
                            aSeq = activityValues.getString("aSeq")
                    )
                    activitiesList.add(Activity(name = activity, type = type, values = values, sequencing = activityObject.getDouble("sequencing")))
                }
            }
            return activitiesList
        }
        inputData.keys().forEach { activityTopic ->
            activityTopicList.add(ActivityTopic(name = activityTopic, activities = generateTopicActivities(activityTopic)))
        }

        return activityTopicList
    }
}