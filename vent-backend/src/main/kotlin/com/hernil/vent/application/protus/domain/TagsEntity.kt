package com.hernil.vent.application.protus.domain

import javax.persistence.*

@Entity
@Table(name = "tags", schema = "protus", catalog = "")
data class TagsEntity (
        @get:Id
        @get:Column(name = "idtags")
        var idtags: Int = 0,
        @get:Basic
        @get:Column(name = "resurs")
        var resurs: Int = 0,
        @get:Basic
        @get:Column(name = "value")
        var value: String? = null
) {
}
