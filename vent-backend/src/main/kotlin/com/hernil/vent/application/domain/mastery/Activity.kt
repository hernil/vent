package com.hernil.vent.application.domain.mastery

import javax.persistence.*

@Entity
data class ActivityTopic(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private val id: Long = 0,
        val name: String = "",
        @OneToMany(cascade = [CascadeType.ALL])
        val activities: List<Activity> = mutableListOf()
)

@Entity
data class Activity(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private val id: Long = 0,
        val name: String = "",
        val type: String = "",
        @OneToOne(cascade = [CascadeType.ALL])
        val values: ActivityValue? = null,
        val sequencing: Double = 0.0
) {
}

@Entity
data class ActivityValue(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private val id: Long = 0,
        val knowledge: Double = 0.0,
        val progress: Boolean = false,
        val a: Double = 0.0,
        val s: Double = 0.0,
        val t: Double = 0.0,
        val aSeq: String = ""
)