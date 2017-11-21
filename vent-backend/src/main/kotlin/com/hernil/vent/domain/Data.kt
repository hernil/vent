package com.hernil.vent.domain

import javax.persistence.*

@Entity
data class Data(val name: String = "",
                @ElementCollection
                val data: List<Double> = listOf(0.0),
                @Id
                @GeneratedValue(strategy = GenerationType.AUTO)
                val id: Long = 0)