package com.hernil.vent.application.vent.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

interface Unit {
    val name: String
    val type: String
    val topic: String
    val difficulty: Int
    val timeSpent: Int
    val performance: Double
}

@Entity
data class CourseUnit(
        @Id
        @JsonIgnore
        @GeneratedValue(strategy = GenerationType.AUTO)
        val did: Long = 0,
        override val name: String = "",
        override val type: String = "",
        override val topic: String = "",
        override val difficulty: Int = 0,
        val opened: Double = 0.0,
        val completed: Double = 0.0,
        val recommended: Double = 0.0,
        override val timeSpent: Int = 0,
        override val performance: Double = 0.0
        ) : Unit {

}

@Entity
data class StudentUnit(
        @Id
        @JsonIgnore
        @GeneratedValue(strategy = GenerationType.AUTO)
        val did: Long = 0,
        override val name: String = "",
        override val type: String = "",
        override val topic: String = "",
        override val difficulty: Int = 0,
        val opened: Boolean = false,
        val completed: Boolean = false,
        val recommended: Boolean = false,
        override val timeSpent: Int = 0,
        override val performance: Double = 0.0
        ) : Unit {

}