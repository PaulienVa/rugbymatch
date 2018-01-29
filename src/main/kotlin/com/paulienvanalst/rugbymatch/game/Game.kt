package com.paulienvanalst.rugbymatch.game


// deze class heeft state
class Game (private var score: Score, private var time: Int) {


}

// extension functions
class Score (private var home: Pair<String, Int>, private var visitors: Pair<String, Int>){
    override fun toString(): String {
//        return home.first + " " +  home.second + " - " + visitors.second + " " + visitors.first

        return "${home.team()} ${home.points()} - ${visitors.points()} ${visitors.team()}"
    }

    private fun Pair<String, Int>.team() = this.first
    private fun Pair<String, Int>.points() = this.second
}


