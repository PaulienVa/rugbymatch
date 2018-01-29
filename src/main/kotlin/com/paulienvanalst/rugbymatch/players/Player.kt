package com.paulienvanalst.rugbymatch.players

enum class Team { HARLEQUINS, WASPS, SARACENS }

interface Player {
    val team : Team
    val position : Position
    val isValid : Boolean
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
