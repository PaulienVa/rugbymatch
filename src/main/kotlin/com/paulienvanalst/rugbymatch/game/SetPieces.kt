package com.paulienvanalst.rugbymatch.game

import com.paulienvanalst.rugbymatch.events.SetPieceEvent
import com.paulienvanalst.rugbymatch.team.Team

//interface SetPiece {
//    val teamThrowingIn: Team
//    val otherTeam: Team
//
//    fun isValid() : Boolean
//}
//
//data class Scrum(override val teamThrowingIn : Team, override val otherTeam: Team) : SetPiece {
//    override fun isValid() : Boolean{
//       return teamThrowingIn.hasEnoughScrumPlayersInPlay() and otherTeam.hasEnoughScrumPlayersInPlay()
//    }
//
//}
//data class LineOut(override val teamThrowingIn : Team, override val otherTeam: Team, val numberOfPlayersTeamThrowingIn: Int, val numberOfPlayersOtherTeam: Int) : SetPiece {
//    override fun isValid(): Boolean {
//        return numberOfPlayersTeamThrowingIn == numberOfPlayersOtherTeam
//    }
//}

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
