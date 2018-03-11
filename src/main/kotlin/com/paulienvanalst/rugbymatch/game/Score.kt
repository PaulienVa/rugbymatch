package com.paulienvanalst.rugbymatch.game

import com.paulienvanalst.rugbymatch.team.TeamName

enum class Type(val points: Int) { TRY(5), TRANSFORMED_TRY(7), DROP_GOA(3), PENALTY(3) }

data class Score(val forTeam: TeamName, val type: Type)

data class GameScore(val hostingTeamScore: Pair<TeamName, Int>, val visitingTeamScore: Pair<TeamName, Int>)


//  Ex 2 ----
private fun List<Score>.getTotalScoreOf(teamName: TeamName) : Int = this.filter { it.forTeam == teamName }.map { it.type.points }.sum()

fun List<Score>.getGameScore(hostingTeam: TeamName, visitingTeam : TeamName) : GameScore =  GameScore(
        hostingTeam to this.getTotalScoreOf(hostingTeam),
        visitingTeam to this.getTotalScoreOf(visitingTeam)
)
//-----