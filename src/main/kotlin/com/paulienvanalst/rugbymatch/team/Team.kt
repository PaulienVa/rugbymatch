package com.paulienvanalst.rugbymatch.team

data class Team (var players: List<Player>, var name: TeamName) {

    val hasEnoughPlayers : Boolean  = players.count() >= 15

    val hasEnoughStartingPlayers : Boolean = players.count { it.isStarting } >= 15

    val hasAnySubstitutes : Boolean = players.any { !it.isStarting }

    val scrumHalf : Player? = players.find { it.position == Position.SCRUM_HALF }

    val nrOfPlayersInlineOut: Int = players.count { it.position.isFrontFive() }

    fun captainBackNumber() : Int = this.scrumHalf!!.backNumber

    fun replacingCaptainBackNumber() : Int = this.scrumHalf?.backNumber ?: players.first { it.isStarting }.backNumber

    fun hasEnoughScrumPlayersInPlay(): Boolean {
        return players.map { it.position }.containsAll(Position.getForwards())
    }

    fun withExtraLock() : Team  {
        val newBackNumber = this.players.size + 1
        val newListOfPlayers = this.players + Player(Position.LOCK, newBackNumber)
        return this.copy(newListOfPlayers, this.name)
    }

}