package com.hernil.vent


data class Data(var id: Long = 0) {
    var name: String = "Nils"


    val data: DoubleArray = doubleArrayOf(7.0, 6.9, 3.0, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6)

    init {
        print("test " + name)
    }
}