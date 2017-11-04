package com.hernil.vent

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Data(val name: String = "",
           @Id
           @GeneratedValue(strategy = GenerationType.AUTO)
           val id: Long = 0)