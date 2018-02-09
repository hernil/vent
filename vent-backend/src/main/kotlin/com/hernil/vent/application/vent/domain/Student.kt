package com.hernil.vent.application.vent.domain

import com.hernil.vent.application.vent.domain.mappers.CourseStudents
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.*

@Entity
data class Student(@Id
                   @GeneratedValue(strategy = GenerationType.AUTO)
                   val id: Long = 0,
                   override val name: String = "",
                   @OneToMany(mappedBy = "student")
                   var courses: List<CourseStudents> = mutableListOf()
) : Person(name) {
}

interface StudentRepository : JpaRepository<Student, Long>