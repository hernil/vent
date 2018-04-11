package com.hernil.vent.application.vent.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.*

@Entity
data class Student(@Id
                   @JsonIgnore
                   @GeneratedValue(strategy = GenerationType.AUTO)
                   val did: Long = 0,
                   val id: String = "",
                   val performance: Double = 0.0,
                   @OneToMany(cascade = arrayOf(CascadeType.ALL))
                   val units: List<StudentUnit> = listOf()
) {
}

interface StudentRepository : JpaRepository<Student, Long>