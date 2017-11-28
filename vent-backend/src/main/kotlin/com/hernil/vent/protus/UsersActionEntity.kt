package com.hernil.vent.protus

import javax.persistence.*
import java.sql.Timestamp

@Entity
@Table(name = "users_action", schema = "protus", catalog = "")
data class UsersActionEntity (
        @get:Id
        @get:Column(name = "idUsers_action")
        var idUsersAction: Int = 0,
        @get:Basic
        @get:Column(name = "lesson")
        var lesson: Int? = null,
        @get:Basic
        @get:Column(name = "menu_item")
        var menuItem: Int? = null,
        @get:Basic
        @get:Column(name = "dimension")
        var dimension: String? = null,
        @get:Basic
        @get:Column(name = "category")
        var category: String? = null,
        @get:Basic
        @get:Column(name = "statistics_tab")
        var statisticsTab: Int? = null,
        @get:Basic
        @get:Column(name = "tags_tab")
        var tagsTab: Int? = null,
        @get:Basic
        @get:Column(name = "session")
        var session: Int? = null,
        @get:Basic
        @get:Column(name = "changed_item")
        var changedItem: Int? = null,
        @get:Basic
        @get:Column(name = "time")
        var time: Timestamp? = null
) {
}
