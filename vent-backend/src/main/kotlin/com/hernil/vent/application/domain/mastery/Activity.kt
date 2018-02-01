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
        var values: ActivityValue? = null,
        var sequencing: Double = 0.0
) {
}

@Entity
data class ActivityValue(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private val id: Long = 0,
        var knowledge: Double = 0.0,
        var progress: Boolean = false,
        var a: Double = 0.0,
        var s: Double = 0.0,
        var t: Double = 0.0,
        var aSeq: String = ""
)