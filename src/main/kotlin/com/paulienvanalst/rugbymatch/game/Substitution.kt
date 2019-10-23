package com.paulienvanalst.rugbymatch.game

import com.paulienvanalst.rugbymatch.team.Player
import com.paulienvanalst.rugbymatch.team.TeamName

data class Substitution(val teamName: TeamName, val subPlayer: Player, val formerPlayer: Player)