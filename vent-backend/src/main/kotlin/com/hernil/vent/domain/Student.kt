package com.hernil.vent.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.hernil.vent.domain.mappers.CourseStudents
import javax.persistence.*

@Entity
data class Student(@Id
                   @GeneratedValue(strategy = GenerationType.AUTO)
                   val id: Long = 0,
                   override val name: String = "",
                   @OneToMany(mappedBy = "student")
                   //@JsonManagedReference
                   //@JsonIgnoreProperties("students")
                   @JsonIgnore
                   var courses: List<CourseStudents> = mutableListOf()
) : Person(name) {
}