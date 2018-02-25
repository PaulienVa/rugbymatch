package com.paulienvanalst.rugbymatch.game

import com.paulienvanalst.rugbymatch.Team
import com.paulienvanalst.rugbymatch.TeamName
import com.paulienvanalst.rugbymatch.events.ScoringEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.math.BigInteger

@Component
class ScoringBoard {
    lateinit var scoreHostingTeam : Score
    lateinit var scoreVisitingTeam : Score

    @EventListener(condition = "#scoringEvent")
    fun teamHasScored(scoringEvent: ScoringEvent) {
        val incomingScore = scoringEvent.score
        if (incomingScore.forTeam == scoreHostingTeam.forTeam) {
            scoreHostingTeam += incomingScore
        }

    }

}

open class Score(val forTeam: TeamName, val points: Int) {
    operator fun plus(other: Score) : Score{
        if (this.forTeam != other.forTeam) {
            throw InvalidScoreException(other)
        }
        return Score(this.forTeam, this.points + other.points)
    }

    override fun equals(other: Any?): Boolean {
        val scoreOfOther = other as Score
        return this.forTeam == scoreOfOther.forTeam && this.points == scoreOfOther.points
    }
}

class Penalty(forTeam: TeamName) : Score(forTeam, 3)
class DropGoal(forTeam: TeamName) : Score(forTeam, 3)
class Try(forTeam: TeamName) : Score(forTeam, 5)
class Transformation(forTeam: TeamName) : Score(forTeam, 2)

class InvalidScoreException(score: Score) : RuntimeException("It is not possible to add the score for ${score.forTeam} to existing score")