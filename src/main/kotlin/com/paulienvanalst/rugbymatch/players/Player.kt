package com.paulienvanalst.rugbymatch.players

data class Player(val team: String, val position: Int) {
    val isStarting : Boolean
        get() = position in 1..15

}