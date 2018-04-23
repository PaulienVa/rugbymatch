package com.paulienvanalst.rugbymatch.game

import com.paulienvanalst.rugbymatch.events.ScoringEvent
import com.paulienvanalst.rugbymatch.events.StartGame
import com.paulienvanalst.rugbymatch.team.TeamName
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
//Ex 3
class ScoringBoard {
    private lateinit var hostingTeam : TeamName
    private lateinit var visitingTeam : TeamName

    private var scoringHistory : List<Score> = emptyList()

    @EventListener
    fun initialize(start: StartGame) {
        hostingTeam = start.hostingTeam
        visitingTeam = start.visitingTeam
    }

    @EventListener
    fun teamHasScored(scoringEvent: ScoringEvent) {
        scoringHistory += Score(scoringEvent.team, scoringEvent.type)
    }

    fun currentScore() : GameScore  {
        return scoringHistory.getGameScore(hostingTeam, visitingTeam)
    }

    fun clear () {
        scoringHistory = emptyList()

    }
}


class TheGameWasNotStartedException : RuntimeException("The game was not started yet. Please start the game before trying to score.")
