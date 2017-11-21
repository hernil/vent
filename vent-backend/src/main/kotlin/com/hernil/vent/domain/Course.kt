package com.hernil.vent.domain

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.hernil.vent.domain.mappers.CourseStudents
import javax.persistence.*

@Entity
data class Course(@Id
                  @GeneratedValue(strategy = GenerationType.AUTO)
                  val id: Long = 0,
                  val code: String = "",
                  val name: String = "",
                  @OneToMany(mappedBy = "course")
                  //@JsonBackReference
                  //@JsonIgnoreProperties("courses")
                  //@JsonIgnore
                  var students: List<CourseStudents> = mutableListOf()
) {
}