package com.hernil.vent.application.mastery.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Topic(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private val id: Long = 0,
        val description: String = "",
        @OneToMany(cascade = [CascadeType.ALL])
        var values: List<TopicValue> = mutableListOf(),
        @OneToMany(cascade = [CascadeType.ALL])
        var sequencing: List<TopicSequencing> = mutableListOf(),
        var overallKnowledge: Double = 0.0,
        var overallProgress: Boolean = false
) {
}

@Entity
data class TopicValue(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @JsonIgnore
        private val id: Long = 0,
        val type: String = "",
        // According to Boban always zero but might change
        val knowledge: Double = 0.0,
        val progress: Boolean = false

)

@Entity
data class TopicSequencing(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private val id: Long = 0,
        val type: String = "",
        val value: Double = 0.0
)

@Entity
data class TopicOverall(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private val id: Long = 0,
        val knowledge: Double = 0.0,
        val progress: Boolean = false
)