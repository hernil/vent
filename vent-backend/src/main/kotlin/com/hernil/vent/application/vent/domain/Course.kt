package com.hernil.vent.application.vent.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.*

@Entity
data class Course(@Id
                  @JsonIgnore
                  @GeneratedValue(strategy = GenerationType.AUTO)
                  val did: Long = 0,
                  val id: String = "",
                  val name: String = "",
                  @OneToMany(cascade = arrayOf(CascadeType.ALL))
                  val units: MutableList<CourseUnit> = mutableListOf(),
                  @OneToMany(cascade = arrayOf(CascadeType.ALL))
                  var students: MutableList<Student> = mutableListOf()
) {
}

interface CourseRepository : JpaRepository<Course, Long> {
    fun findById(id: String): Course
}