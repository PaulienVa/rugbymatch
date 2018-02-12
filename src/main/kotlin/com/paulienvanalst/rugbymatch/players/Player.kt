package com.paulienvanalst.rugbymatch.players

import org.apache.logging.log4j.LogManager

private val logger = LogManager.getLogger(Player::class.java)

enum class Team { HARLEQUINS, WASPS, SARACENS }

interface Player {
    val team : Team
    val position : Position
    val isValid : Boolean

//    fun run()
//
//    fun scrum()
//
//    fun playLineOut()
//
//    fun pass()

    fun tackle(opponent: Player) : Player {
        if (this.team != opponent.team) {
            logger.error("Please do not tackle a player of your own team ... ")
        }
    }
}

data class Forward (override val team: Team, override val position: Position) : Player {
    override val isValid = position in Position.getForwards()
}

data class HalfBack (override val team : Team, override val position : Position) : Player {
    override val isValid: Boolean = position in Position.getHalfBacks()
}

data class Back (override val team : Team, override val position : Position) : Player {
    override val isValid: Boolean = position in Position.getBacks()
}
