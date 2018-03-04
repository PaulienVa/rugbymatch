package com.paulienvanalst.rugbymatch.game

import com.paulienvanalst.rugbymatch.events.ScoringEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class ScoringBoard {
    lateinit var scoreHostingTeam : Score
    lateinit var scoreVisitingTeam : Score

    @EventListener(condition = "#scoringEvent")
    fun teamHasScored(scoringEvent: ScoringEvent) {
        val incomingScore = scoringEvent.score
        if (incomingScore.forTeam == scoreHostingTeam.forTeam) {
            scoreHostingTeam += incomingScore
        } else if (incomingScore.forTeam == scoreVisitingTeam.forTeam) {
            scoreVisitingTeam += incomingScore
        }

    }

}