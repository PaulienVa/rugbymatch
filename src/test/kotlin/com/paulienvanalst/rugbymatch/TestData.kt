package com.paulienvanalst.rugbymatch

import com.paulienvanalst.rugbymatch.team.Player
import com.paulienvanalst.rugbymatch.team.Position
import com.paulienvanalst.rugbymatch.team.Team

class TeamTestData {
    fun  inValidTeam (teamName: TeamName) : Team {
        return Team(players = backPlayers(), name = teamName)
    }


    fun validTeam (teamName: TeamName) : Team {
        return Team(players = scrumPlayers() + backPlayers(), name = teamName)
    }

    private fun scrumPlayers() : List<Player> {
        return listOf(
                Player(Position.LOOSEHEAD_PROP, 1),
                Player(Position.HOOKER, 2),
                Player(Position.TIGHTHEAD_PROP, 3),
                Player(Position.LOCK, 4),
                Player(Position.LOCK, 5),
                Player(Position.FLANKER, 6),
                Player(Position.FLANKER, 7),
                Player(Position.NR8, 8)
        )
    }

    private fun backPlayers() : List<Player> {
        return listOf(
                Player(Position.SCRUM_HALF, 9),
                Player(Position.FLY_HALF, 10),
                Player(Position.CENTER, 12),
                Player(Position.CENTER, 13),
                Player(Position.WING, 11),
                Player(Position.WING, 14),
                Player(Position.FULLBACK, 15)
        )
    }
}