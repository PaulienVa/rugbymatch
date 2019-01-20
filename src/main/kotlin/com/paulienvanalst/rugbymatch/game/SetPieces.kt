package com.paulienvanalst.rugbymatch.game

import com.paulienvanalst.rugbymatch.team.NotImplementedException
import com.paulienvanalst.rugbymatch.team.Team


interface SetPiece {
//    val attackingTeam: Team
//    val defendingTeam: Team

    fun isValid() : Boolean
}

data class Scrum(val attackingTeam: Team, val defendingTeam: Team) : SetPiece {

    /**
     * A scrum is valid when both teams participating have a scrum
     */
    override fun isValid(): Boolean {
        throw NotImplementedException()
    }
}

/**
 * A lineout is valid when both team participating have the same number of players playing the line-out
 */

data class LineOut(val attackingTeam: Team, val defendingTeam: Team) : SetPiece {

    override fun isValid(): Boolean {
        throw NotImplementedException()
    }
}
