package com.paulienvanalst.rugbymatch.events

import com.paulienvanalst.rugbymatch.team.Player
import com.paulienvanalst.rugbymatch.team.TeamName
import org.springframework.context.ApplicationEvent

class SubstitutionAnnounced(source: Any, val teamName: TeamName, val startingPlayer: Player, val sub: Player) : ApplicationEvent(source)
class SubstitutionPerformed(source: Any, val teamName: TeamName, val players: List<Player>) : ApplicationEvent(source)
class SquadAnnounced(source: Any, val startingPlayers: List<Player>, val teamName: TeamName) : ApplicationEvent(source)