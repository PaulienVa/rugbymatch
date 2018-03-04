package com.paulienvanalst.rugbymatch.game

import com.paulienvanalst.rugbymatch.TeamName

open class Score(val forTeam: TeamName, private val points: Int) {
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

    override fun hashCode(): Int {
        var result = forTeam.hashCode()
        result = 31 * result + points
        return result
    }
}

fun List<Score>.getTries() : Int = this.count { score -> score is Try }

class Penalty(forTeam: TeamName) : Score(forTeam, 3)
class DropGoal(forTeam: TeamName) : Score(forTeam, 3)
class Try(forTeam: TeamName) : Score(forTeam, 5)
class Transformation(forTeam: TeamName) : Score(forTeam, 2)

class InvalidScoreException(score: Score) : RuntimeException("It is not possible to add the score for ${score.forTeam} to existing score")