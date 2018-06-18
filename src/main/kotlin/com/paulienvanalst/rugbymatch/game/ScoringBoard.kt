package com.paulienvanalst.rugbymatch.game

import com.paulienvanalst.rugbymatch.events.ScoringEvent
import com.paulienvanalst.rugbymatch.events.StartGame
import com.paulienvanalst.rugbymatch.team.NotImplementedException
import com.paulienvanalst.rugbymatch.team.TeamName
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
open class ScoringBoard {

    private var scoringHistory : List<Score> = emptyList()

    fun currentScore(): GameScore {
        throw NotImplementedException()
    }

    fun clear () {
        scoringHistory = emptyList()

    }
}


