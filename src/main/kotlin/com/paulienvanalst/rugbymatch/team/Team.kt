package com.paulienvanalst.rugbymatch.team

data class Team (val players: List<Player>, val name: TeamName) {

    val hasEnoughPlayers : Boolean  = players.count() >= 15

    val hasEnoughStartingPlayers : Boolean = players.filter { it.isStarting }.count() >= 15

    val hasAnySubstitutes : Boolean = players.any { !it.isStarting }

    val scrumHalf : Player? = players.find { it.position == Position.SCRUM_HALF }

    fun captainBackNumber() : Int = this.scrumHalf!!.backNumber

    fun replacingCaptainBackNumber() : Int = this.scrumHalf?.backNumber ?: players.first { it.isStarting }.backNumber

    fun hasScrum(): Boolean {
        return players.map { it.position }.containsAll(Position.getForwards())
    }

}

