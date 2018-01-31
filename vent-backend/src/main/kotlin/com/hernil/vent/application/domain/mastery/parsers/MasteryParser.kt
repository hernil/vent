package com.hernil.vent.application.domain.mastery.parsers

import com.hernil.vent.application.domain.mastery.*
import org.json.JSONObject

class MasteryParser(inputData: JSONObject) {

    val parsedData: Learner = Learner(
            id = inputData.getString("id"),
            name = inputData.getString("name"),
            topics = topicGenerator(inputData.getJSONObject("state").getJSONObject("topics")),
            activities = activityGenerator(inputData.getJSONObject("state").getJSONObject("activities")))

    fun topicGenerator(topics: JSONObject): MutableList<Topic> {
        val topicList: MutableList<Topic> = mutableListOf()

        topics.keys().forEach {
            var topic = topics.getJSONObject(it)
            var overall_knowledge = topic.getJSONObject("overall").getDouble("k")
            var overall_progress = topic.getJSONObject("overall").getInt("p") == 1
            var sequencing: MutableList<TopicSequencing> = mutableListOf()

            var sl = topic.getJSONObject("sequencing")
            sl.keys().forEach { topic ->
                sequencing.add(TopicSequencing(type = topic, value = sl.getDouble(topic)))
            }

            var valueList: MutableList<TopicValue> = mutableListOf()

            var jsonValues = topic.getJSONObject("values")

            jsonValues.keys().forEach {
                valueList.add(TopicValue(type = it as String, knowledge = jsonValues.getJSONObject(it).getDouble("k")))
            }

            topicList.add(
                    Topic(
                            description = it as String,
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