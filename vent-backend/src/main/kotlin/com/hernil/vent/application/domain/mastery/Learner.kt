package com.hernil.vent.application.domain.mastery

import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.*

@Entity
data class Learner(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val dId: Long = 0,
        val id: String = "",
        val name: String = "",
        @OneToMany(cascade = [CascadeType.ALL])
        var topics: List<Topic> = mutableListOf(),
        @OneToMany(cascade = [CascadeType.ALL])
        var activities: MutableList<ActivityTopic> = mutableListOf()
)

interface MasteryLearnerRepository : JpaRepository<Learner, Long>