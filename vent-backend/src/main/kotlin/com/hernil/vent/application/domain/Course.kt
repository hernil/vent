package com.hernil.vent.application.domain

import com.hernil.vent.application.domain.mappers.CourseStudents
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.*

@Entity
data class Course(@Id
                  @GeneratedValue(strategy = GenerationType.AUTO)
                  val id: Long = 0,
                  val code: String = "",
                  val name: String = "",
                  @OneToMany(mappedBy = "course")
                  var students: List<CourseStudents> = mutableListOf()
) {
}

interface CourseRepository : JpaRepository<Course, Long>