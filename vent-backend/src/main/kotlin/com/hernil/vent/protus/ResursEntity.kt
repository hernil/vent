package com.hernil.vent.protus

import javax.persistence.*

@Entity
@Table(name = "resurs", schema = "protus", catalog = "")
data class ResursEntity (
        @get:Id
        @get:Column(name = "idresurs")
        var idresurs: Int = 0,
        @get:Basic
        @get:Column(name = "type")
        var type: String? = null
){
}
