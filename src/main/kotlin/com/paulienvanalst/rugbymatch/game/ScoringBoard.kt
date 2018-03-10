package com.paulienvanalst.rugbymatch.game

import com.paulienvanalst.rugbymatch.TeamName
import com.paulienvanalst.rugbymatch.events.ScoringEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class ScoringBoard {
    private lateinit var hostingTeam : TeamName
    private lateinit var visitingTeam : TeamName

    //todo move to repo
    private var scoringHistory : List<Score> = emptyList()

    @EventListener
    fun initialize(start: StartGame) {
        hostingTeam = start.hostingTeam
        visitingTeam = start.visitingTeam
    }

    @EventListener
    fun teamHasScored(scoringEvent: ScoringEvent) {

        //todo fix this
        if(hostingTeam == null || visitingTeam == null) {
            throw TheGameWasNotStartedException()
        }

        scoringHistory += Score(scoringEvent.team, scoringEvent.type)

    }

    fun currentScore() : GameScore  {
        return scoringHistory.getGameScore(hostingTeam, visitingTeam)
    }
}


class TheGameWasNotStartedException : RuntimeException("The game was not started yet. Please start the game before trying to score.")
