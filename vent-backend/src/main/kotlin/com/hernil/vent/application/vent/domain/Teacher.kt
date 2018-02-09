package com.hernil.vent.application.vent.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Teacher(@Id
                   @GeneratedValue(strategy = GenerationType.AUTO)
                   val id: Long = 0,
                   override val name: String = "") : Person(name) {
}