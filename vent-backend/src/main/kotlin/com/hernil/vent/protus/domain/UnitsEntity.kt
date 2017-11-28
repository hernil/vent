package com.hernil.vent.protus.domain

import javax.persistence.*

@Entity
@Table(name = "units", schema = "protus", catalog = "")
data class UnitsEntity (
        @get:Id
        @get:Column(name = "idunits")
        var idunits: Int = 0,
        @get:Basic
        @get:Column(name = "name")
        var name: String? = null
) {
}
