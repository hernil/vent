package com.hernil.vent.application.protus.domain

import javax.persistence.*

@Entity
@Table(name = "action_type", schema = "protus", catalog = "")
data class ActionTypeEntity (
    @get:Id
    @get:Column(name = "idaction_type")
    var idactionType: Int = 0,
    @get:Basic
    @get:Column(name = "action_type")
    var actionType: String? = null,
    @get:Basic
    @get:Column(name = "comment")
    var comment: String? = null
    ) {
}
