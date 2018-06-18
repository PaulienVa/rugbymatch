package com.paulienvanalst.rugbymatch.team


data class Team (val players: List<Player>, val name: TeamName) {
    /**
     * A team has enough players when it has at least 15 players
     */
    val hasEnoughPlayers : Boolean
        get() = throw NotImplementedException()

    /**
     * A team has substitutes when it has more than 15 players
     */
    val hasAnySubstitutes : Boolean
        get() = throw NotImplementedException()

    /**
     * A team has enough starting players when there are at least 15 players
     * wearing back numbers 1 until 15
     */
    val hasEnoughStartingPlayers : Boolean
        get() = throw NotImplementedException()

    /**
     * The captain, when present, should always where back number 9
     */
    fun captainBackNumber(): Int? {
        throw NotImplementedException()
    }

    /**
     * When no scrumhalf present (player with back number 9)
     * the captain is wearing the first back number we can find among the starting players.
     */
    fun replacingCaptainBackNumber(): Int? {
        throw NotImplementedException()
    }


}

