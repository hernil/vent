package com.hernil.vent.application.protus.domain

import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.*

@Entity
@Table(name = "learners", schema = "protus", catalog = "")
data class LearnersEntity(
        @get:Id
        @get:Column(name = "id")
        var id: Int = 0,
        @get:Basic
        @get:Column(name = "ime")
        var firstname: String? = null,
        @get:Basic
        @get:Column(name = "prezime")
        var lastname: String? = null,
        @get:Basic
        @get:Column(name = "username")
        var username: String? = null,
        @get:Basic
        @get:Column(name = "password")
        var password: String? = null,
        @get:Basic
        @get:Column(name = "year")
        var year: Int = 0,
        @get:Basic
        @get:Column(name = "processing")
        var processing: Int = 0,
        @get:Basic
        @get:Column(name = "percepcion")
        var percepcion: Int = 0,
        @get:Basic
        @get:Column(name = "recepcion")
        var recepcion: Int = 0,
        @get:Basic
        @get:Column(name = "understanding")
        var understanding: Int = 0,
        @get:Basic
        @get:Column(name = "percentage")
        var percentage: Double = 0.toDouble(),
        @get:Basic
        @get:Column(name = "avg_grade")
        var avgGrade: Double = 0.toDouble(),
        @get:Basic
        @get:Column(name = "lesson")
        var lesson: Int = 0,
        @get:Basic
        @get:Column(name = "resurs")
        var resurs: Int = 0,
        @get:Basic
        @get:Column(name = "course")
        var course: Int? = null,
        @get:Basic
        @get:Column(name = "masteryID")
        var masteryId: String? = null,
        @get:Basic
        @get:Column(name = "ELOrating")
        var elOrating: Int? = null,
        @get:Basic
        @get:Column(name = "iteraction_num")
        var iteractionNum: Int? = null,
        @Basic
        @Column(name = "k_factor")
        private var kFactor: Int? = null
) {

}

interface LearnersRepository : JpaRepository<LearnersEntity, Int>
