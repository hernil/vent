package com.hernil.vent.application.protus.domain

import javax.persistence.*
import java.sql.Timestamp

@Entity
@Table(name = "messages", schema = "protus", catalog = "")
class MessagesEntity (
        @get:Id
        @get:Column(name = "idmessages")
        var idmessages: Int = 0,
        @get:Basic
        @get:Column(name = "sendertype")
        var sendertype: Int = 0,
        @get:Basic
        @get:Column(name = "recipienttype")
        var recipienttype: Int = 0,
        @get:Basic
        @get:Column(name = "time")
        var time: Timestamp? = null,
        @get:Basic
        @get:Column(name = "text")
        var text: String? = null
) {
}
