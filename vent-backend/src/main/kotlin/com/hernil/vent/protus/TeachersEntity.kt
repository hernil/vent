package com.hernil.vent.protus

import javax.persistence.*

@Entity
@Table(name = "teachers", schema = "protus", catalog = "")
data class TeachersEntity (
        @get:Id
        @get:Column(name = "idteachers")
        var idteachers: Int = 0,
        @get:Basic
        @get:Column(name = "firstname")
        var firstname: String? = null,
        @get:Basic
        @get:Column(name = "lastname")
        var lastname: String? = null,
        @get:Basic
        @get:Column(name = "username")
        var username: String? = null,
        @get:Basic
        @get:Column(name = "password")
        var password: String? = null,
        @get:Basic
        @get:Column(name = "title")
        var title: String? = null
) {
}
