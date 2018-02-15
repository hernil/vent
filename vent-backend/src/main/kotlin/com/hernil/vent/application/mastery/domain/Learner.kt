package com.hernil.vent.application.mastery.domain

import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.*

@Entity
data class Learner(
        @Id
        val id: String = "",
        val name: String = "",
        @OneToMany(cascade = [CascadeType.ALL])
        val topics: List<Topic> = mutableListOf(),
        @OneToMany(cascade = [CascadeType.ALL])
        val activityTopic: List<ActivityTopic> = mutableListOf()
)

interface MasteryLearnerRepository : JpaRepository<Learner, Long>