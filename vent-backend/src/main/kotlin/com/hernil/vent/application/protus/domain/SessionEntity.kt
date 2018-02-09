package com.hernil.vent.application.protus.domain

import javax.persistence.*
import java.sql.Time
import java.sql.Timestamp

@Entity
@Table(name = "session", schema = "protus", catalog = "")
data class SessionEntity (
        @get:Id
        @get:Column(name = "idsession")
        var idsession: Int = 0,
        @get:Basic
        @get:Column(name = "sessiontime")
        var sessiontime: Time? = null,
        @get:Basic
        @get:Column(name = "date")
        var date: Timestamp? = null
) {
}
