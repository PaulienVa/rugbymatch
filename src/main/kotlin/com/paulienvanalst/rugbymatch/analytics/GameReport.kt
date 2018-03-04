package com.paulienvanalst.rugbymatch.analytics

import com.paulienvanalst.rugbymatch.Team
import com.paulienvanalst.rugbymatch.TeamName
import com.paulienvanalst.rugbymatch.events.ScoringEvent
import com.paulienvanalst.rugbymatch.game.Score
import com.paulienvanalst.rugbymatch.game.getTries
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class GameReport {

    @Autowired
    lateinit var eventPublisher: ApplicationEventPublisher

    lateinit var scoringHistory : ScoringHistory

    @EventListener(condition = "#scoringEvent")
    fun updatingReportAfterScoringEvent(scoringEvent: ScoringEvent) {
        scoringHistory.addNewScore(scoringEvent.score)
    }

    @EventListener(condition = "#lineOut") // 4
    @EventListener(condition = "#scrums")
    @EventListener(condition = "#penalty")

//    @EventListener(endGame, endPeriod)

    fun generateReport() : ScoringReport {
        eventPublisher.publishEvent(ScoringReportIsGenerated(this, ScoringReport(scoringHistory)))
    }
}

class ScoringReportIsGenerated (source: Any?, val report : ScoringReport) : ApplicationEvent(source)

class ScoringReport (val scoringHistory: ScoringHistory) {
    fun retrieveNumberOfTriesOfTeam(team: TeamName) : Int {
        return scoringHistory.scoresPerTeam[team]?.getTries() ?: 0
    }
}

class ScoringHistory (val scoresPerTeam: Map<TeamName, List<Score>>){
    fun addNewScore(score: Score) : ScoringHistory{
        if (scoresPerTeam.containsKey(score.forTeam)) {
            val elements : List<Score> = scoresPerTeam[score.forTeam].toList()
            val newScoringList : List<Score> = lis
            return ScoringHistory(mapOf(score.forTeam to newScoringList))
        }
    }
}
