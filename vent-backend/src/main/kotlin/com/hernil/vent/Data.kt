package com.hernil.vent


data class Data(var id: Long = 0) {
    var name: String = "Nils"

    val data: String = ""

    init {
        print("test " + name)
    }
}