package com.paulienvanalst.rugbymatch.game

import com.paulienvanalst.rugbymatch.events.ScoringEvent
import com.paulienvanalst.rugbymatch.events.StartGame
import com.paulienvanalst.rugbymatch.team.TeamName
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class ScoringBoard {

    private var scoringHistory : List<Score> = emptyList()

    fun currentScore(): GameScore {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun clear () {
        scoringHistory = emptyList()

    }
}


