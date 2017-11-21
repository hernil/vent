package com.hernil.vent.domain.mappers

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.hernil.vent.domain.Course
import com.hernil.vent.domain.Student
import java.io.Serializable
import javax.persistence.*

@Entity
data class CourseStudents(@EmbeddedId
                          val id: CourseStudentsId = CourseStudentsId(),
                          @ManyToOne
                          @JoinColumn(insertable = false, updatable = false)
                          @JsonManagedReference
                          val course: Course = Course(),
                          @ManyToOne
                          @JoinColumn(insertable = false, updatable = false)
                          @JsonBackReference
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
