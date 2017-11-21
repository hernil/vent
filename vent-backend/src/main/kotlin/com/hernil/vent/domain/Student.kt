package com.hernil.vent.domain

import javax.persistence.*

@Entity
data class Student(@Id
                   @GeneratedValue(strategy = GenerationType.AUTO)
                   val id: Long = 0,
                   override val name: String = "",
                   val grade: String = ""
) : Person(name) {

    fun testing () {
        println(2*3)
    }
}