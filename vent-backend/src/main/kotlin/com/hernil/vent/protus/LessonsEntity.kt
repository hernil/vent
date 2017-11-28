package com.hernil.vent.protus

import javax.persistence.*

@Entity
@Table(name = "lessons", schema = "protus", catalog = "")
data class LessonsEntity (
        @get:Id
        @get:Column(name = "idlessons")
        var idlessons: Int = 0,
        @get:Basic
        @get:Column(name = "name")
        var name: String? = null,
        @get:Basic
        @get:Column(name = "file")
        var file: String? = null,
        @get:Basic
        @get:Column(name = "resources")
        var resources: Int = 0,
        @get:Basic
        @get:Column(name = "intro")
        var intro: Int = 0,
        @get:Basic
        @get:Column(name = "basicinfo")
        var basicinfo: Int = 0,
        @get:Basic
        @get:Column(name = "example")
        var example: Int = 0,
        @get:Basic
        @get:Column(name = "explanation")
        var explanation: Int = 0,
        @get:Basic
        @get:Column(name = "theory")
        var theory: Int = 0,
        @get:Basic
        @get:Column(name = "activity")
        var activity: Int = 0,
        @get:Basic
        @get:Column(name = "syntax")
        var syntax: Int = 0,
        @get:Basic
        @get:Column(name = "lesson_order")
        var lessonOrder: Int? = null
) {
}
