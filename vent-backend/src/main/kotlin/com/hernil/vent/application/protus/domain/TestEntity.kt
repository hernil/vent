package com.hernil.vent.application.protus.domain

import javax.persistence.*
import java.sql.Timestamp

@Entity
@Table(name = "test", schema = "protus", catalog = "")
data class TestEntity (
        @get:Id
        @get:Column(name = "idtest")
        var idtest: Int = 0,
        @get:Basic
        @get:Column(name = "grade")
        var grade: Double = 0.toDouble(),
        @get:Basic
        @get:Column(name = "passed")
        var passed: Int = 0,
        @get:Basic
        @get:Column(name = "time")
        var time: Timestamp? = null
) {
}
