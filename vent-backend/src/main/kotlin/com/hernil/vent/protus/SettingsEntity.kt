package com.hernil.vent.protus

import javax.persistence.*

@Entity
@Table(name = "settings", schema = "protus", catalog = "")
data class SettingsEntity (
        @get:Id
        @get:Column(name = "idsettings")
        var idsettings: Int = 0,
        @get:Basic
        @get:Column(name = "applytags")
        var applytags: Int = 0,
        @get:Basic
        @get:Column(name = "applyLS")
        var applyLs: Int = 0,
        @get:Basic
        @get:Column(name = "applypatterns")
        var applypatterns: Int = 0,
        @get:Basic
        @get:Column(name = "facultyGrading")
        var facultyGrading: Int = 0
) {
}
