package com.hernil.vent.application.domain

import javax.persistence.*

@Entity
@Table(name = "data")
data class Data(val name: String = "",
                @ElementCollection
                val data: List<Double> = listOf(0.0),
                @Id
                @GeneratedValue(strategy = GenerationType.AUTO)
                val id: Long = 0)