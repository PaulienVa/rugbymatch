package com.paulienvanalst.rugbymatch.game

import com.paulienvanalst.rugbymatch.TeamName

interface  SetPiece {
    val teamInitiallyInPocession: TeamName
    val winingTeam: TeamName

    fun ballPossessionConserved() : Boolean {
        return teamInitiallyInPocession == winingTeam
    }

    fun ballPossessionLost() : Boolean {
        return teamInitiallyInPocession != winingTeam
    }
}

data class Scrum(override val teamInitiallyInPocession : TeamName, override val winingTeam: TeamName) : SetPiece
data class LineOut(override val teamInitiallyInPocession : TeamName, override val winingTeam: TeamName) : SetPiece
