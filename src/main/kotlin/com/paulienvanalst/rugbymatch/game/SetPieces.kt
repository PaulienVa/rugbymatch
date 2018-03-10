package com.paulienvanalst.rugbymatch.game

import com.paulienvanalst.rugbymatch.TeamName


// Ex 2
interface  SetPiece {
    val winingTeam: TeamName

    fun ballPossessionConservedBy(teamInitiallyInPocession: TeamName) : Boolean {
        return teamInitiallyInPocession == winingTeam
    }

    fun ballPossessionLostBy(teamInitiallyInPocession: TeamName) : Boolean {
        return teamInitiallyInPocession != winingTeam
    }
}

data class Scrum(override val winingTeam: TeamName) : SetPiece
data class LineOut(override val winingTeam: TeamName) : SetPiece

fun List<SetPiece>.conservedBy(team: TeamName) = this.filter { it.ballPossessionConservedBy(team) }
fun List<SetPiece>.possessionLostBy(team: TeamName) = this.filter { it.ballPossessionLostBy(team) }