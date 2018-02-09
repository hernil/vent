package com.hernil.vent.application.protus.domain

import javax.persistence.*

@Entity
@Table(name = "courses", schema = "protus", catalog = "")
class CoursesEntity (
    @get:Id
    @get:Column(name = "idcourses")
    var idcourses: Int = 0,
    @get:Basic
    @get:Column(name = "name")
    var name: String? = null,
    @get:Basic
    @get:Column(name = "units")
    var units: Int = 0,
    @get:Basic
    @get:Column(name = "lessons")
    var lessons: Int = 0,
    @get:Basic
    @Column(name = "LSsuported")
    private var lSsuported: String? = null,
    @get:Basic
    @get:Column(name = "student_num")
    var studentNum: Int = 0,
    @get:Basic
    @get:Column(name = "duration")
    var duration: String? = null
) {

}
