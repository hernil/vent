package com.hernil.vent.domain

import javax.persistence.*

@Entity
data class Course(@Id
                  @GeneratedValue(strategy = GenerationType.AUTO)
                  val id: Long = 0,
                  val code: String = "",
                  val name: String = "",
                  @ManyToMany
                  var students: List<Student> = listOf()
) {


}