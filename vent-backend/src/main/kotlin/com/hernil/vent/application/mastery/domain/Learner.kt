package com.hernil.vent.application.mastery.domain

import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.*

@Entity
data class Learner(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private val dId: Long = 0,
        val id: String = "",
        val name: String = "",
        @OneToMany(cascade = [CascadeType.ALL])
        var topics: List<Topic> = mutableListOf(),
        @OneToMany(cascade = [CascadeType.ALL])
        var activityTopic: List<ActivityTopic> = mutableListOf()
)

interface MasteryLearnerRepository : JpaRepository<Learner, Long> {
        fun findById(id: String): Learner
}