package com.hernil.vent.application.domain.mastery.parsers

import com.hernil.vent.application.domain.mastery.*
import com.hernil.vent.application.utils.logger
import org.json.JSONObject

class MasteryParser(inputData: JSONObject) {

    val log by logger()

    val parsedData: Learner = Learner(
            id = inputData.getString("id"),
            name = inputData.getString("name"),
            topics = topicGenerator(inputData.getJSONObject("state").getJSONObject("topics")),
            activityTopic = activityGenerator(inputData.getJSONObject("state").getJSONObject("activities")))

    fun topicGenerator(topics: JSONObject): MutableList<Topic> {
        val topicList: MutableList<Topic> = mutableListOf()

        fun sequencingValuesGenerator(sequencingValuesContainer: JSONObject): MutableList<TopicSequencing> {
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

        fun valuesGenerator(valuesContainer: JSONObject): MutableList<TopicValue> {
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

            val sequencing = sequencingValuesGenerator(topic.getJSONObject("sequencing"))
            val valueList: MutableList<TopicValue> = valuesGenerator(topic.getJSONObject("values"))

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

    fun activityGenerator(activities: JSONObject): MutableList<ActivityTopic> {
        val activityTopicList: MutableList<ActivityTopic> = mutableListOf()

        fun generateTopicActivities(name: String): MutableList<Activity> {
            var ac = activities.getJSONObject(name)
            var list: MutableList<Activity> = mutableListOf()
            ac.keys().forEach { type ->

                val types = ac.getJSONObject(type as String)

                types.keys().forEach { activity ->
                    val activityObject = types.getJSONObject(activity as String)
                    val values: MutableList<ActivityValue> = mutableListOf()

                    values.add(ActivityValue(
                            knowledge = activityObject.getJSONObject("values").getDouble("k"),
                            progress = activityObject.getJSONObject("values").getInt("p") == 1,
                            a = activityObject.getJSONObject("values").getDouble("a"),
                            s = activityObject.getJSONObject("values").getDouble("s"),
                            t = activityObject.getJSONObject("values").getDouble("t"),
                            aSeq = activityObject.getJSONObject("values").getString("aSeq")
                    ))

                    list.add(Activity(name = activity, values = values, sequencing = activityObject.getDouble("sequencing")))
                }


            }
            return list
        }

        activities.keys().forEach { activity ->

            activityTopicList.add(ActivityTopic(name = activity, activities = generateTopicActivities(activity)))


        }

        return activityTopicList
    }
}