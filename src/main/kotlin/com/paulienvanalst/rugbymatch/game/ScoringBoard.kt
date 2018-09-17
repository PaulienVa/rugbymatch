package com.paulienvanalst.rugbymatch.game

import com.paulienvanalst.rugbymatch.team.NotImplementedException
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


