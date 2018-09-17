package com.paulienvanalst.rugbymatch.game

import com.paulienvanalst.rugbymatch.team.Team

interface SetPiece {
    val attackingTeam: Team
    val defendingTeam: Team

    fun isValid(): Boolean
}

data class Scrum(override val attackingTeam: Team, override val defendingTeam: Team) : SetPiece {
    override fun isValid() : Boolean{
        return attackingTeam.hasEnoughScrumPlayersInPlay() and defendingTeam.hasEnoughScrumPlayersInPlay()
    }
}

data class LineOut(override val attackingTeam: Team, override val defendingTeam: Team) : SetPiece {
    override fun isValid(): Boolean {
        return attackingTeam.nrOfPlayersInlineOut == defendingTeam.nrOfPlayersInlineOut
    }

}
