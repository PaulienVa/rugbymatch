package com.paulienvanalst.rugbymatch.game

import org.apache.logging.log4j.LogManager
import org.springframework.context.ApplicationEvent
import org.springframework.context.event.EventListener


// deze class heeft state
class Game (private var score: Score, private var time: Int) {
    private val logger = LogManager.getLogger(Game::class.java)

    @EventListener(condition = "#kickOff")
    fun kickOff(kickOff: KickOff) : String{
        val kickingTeam = kickOff.kickingTeam
        return if (kickOff.distance < 10) {
            logger.info("Kick is less than 10 m")
            "KickOff is less than 10 m"
        } else {
            "Let's play rugby!"
        }
    }



}

// en deze warning?
class KickOff(source: Any?, val kickingTeam: String, val distance: Int) : ApplicationEvent(source)

class KickOffCatched(source: Any?): ApplicationEvent(source)

// extension functions
class Score (private var home: Pair<String, Int>, private var visitors: Pair<String, Int>){
    override fun toString(): String {
//        return home.first + " " +  home.second + " - " + visitors.second + " " + visitors.first

        return "${home.team()} ${home.points()} - ${visitors.points()} ${visitors.team()}"
    }

    private fun Pair<String, Int>.team() = this.first
    private fun Pair<String, Int>.points() = this.second
}


