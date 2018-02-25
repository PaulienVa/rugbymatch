package com.paulienvanalst.rugbymatch

import com.paulienvanalst.rugbymatch.players.Player

class Team (val players: List<Player>, val name: TeamName) {

    val hasEnoughPlayers = players.count()

    val hasEnoughStartingPlayers = players.filter { it.isStarting }.count()

    val hasAnySubstitutes = players.any { !it.isStarting }

//    fun scores(score: Score)
}