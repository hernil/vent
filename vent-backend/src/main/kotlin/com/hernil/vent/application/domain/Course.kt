package com.hernil.vent.application.domain

import com.hernil.vent.application.domain.mappers.CourseStudents
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.persistence.*

@Entity
//@Table(name = "course")
data class Course(@Id
                  @GeneratedValue(strategy = GenerationType.AUTO)
                  val id: Long = 0,
                  val code: String = "",
                  val name: String = "",
                  @OneToMany(mappedBy = "course")
                  var students: List<CourseStudents> = mutableListOf()
) {
}

@Repository
interface CourseRepository : JpaRepository<Course, Long>