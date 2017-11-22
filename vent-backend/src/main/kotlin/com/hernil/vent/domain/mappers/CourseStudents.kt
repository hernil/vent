package com.hernil.vent.domain.mappers

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.hernil.vent.domain.Course
import com.hernil.vent.domain.Student
import java.io.Serializable
import javax.persistence.*

@Entity
data class CourseStudents(@EmbeddedId
                          @JsonIgnore
                          val id: CourseStudentsId = CourseStudentsId(),
                          @ManyToOne
                          @JoinColumn(insertable = false, updatable = false)
                          @JsonIgnoreProperties("students")
                          val course: Course = Course(),
                          @ManyToOne
                          @JoinColumn(insertable = false, updatable = false)
                          @JsonIgnoreProperties("courses")
                          val student: Student = Student(),
                          val grade: String = "") {
}

@Embeddable
data class CourseStudentsId(@Column
                            val course_id: Long = 0,
                            @Column
                            val student_id: Long = 0
) : Serializable {

}
