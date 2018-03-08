package com.paulienvanalst.rugbymatch.analytics

import com.paulienvanalst.rugbymatch.TeamName
import com.paulienvanalst.rugbymatch.events.LineOutWasPlayed
import com.paulienvanalst.rugbymatch.events.ScoringEvent
import com.paulienvanalst.rugbymatch.events.ScrumWasPlayed
import com.paulienvanalst.rugbymatch.events.SetPieceEvent
import com.paulienvanalst.rugbymatch.game.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class GameReporter {

    @Autowired
    lateinit var eventPublisher: ApplicationEventPublisher

    lateinit var gameReport : GameReport

    @EventListener(condition ="#gameIsStarted")
    fun startTheReport(gameIsStarted: GameIsStarted) {
        gameReport = GameReport(gameIsStarted.hostingTeam, gameIsStarted.visitingTeam)
    }

    @EventListener(condition = "#halfTime")
    fun halfTime(halfTime: HalfTime) {
        gameReport.determineHalfTimeScore()
    }

    @EventListener(condition = "#gameIsFinished")
    fun endGame(gameIsFinished: GameIsFinished) {
        gameReport.determineFinalScore()
    }

    @EventListener(condition = "#scoringEvent")
    fun updatingReportAfterScoringEvent(scoringEvent: ScoringEvent) {
        gameReport.addNewScore(scoringEvent.score)
        eventPublisher.publishEvent(GameReportIsGenerated(this, this.gameReport))
    }

    @EventListener(condition = "#setPieceEvent")
    fun updatingReportAfterSetPiece(setPieceEvent: SetPieceEvent) {
        if (setPieceEvent is ScrumWasPlayed) {
            this.gameReport.addScrum(setPieceEvent.scrum)
        } else if (setPieceEvent is LineOutWasPlayed) {
            this.gameReport.addLineOut(setPieceEvent.lineOut)
        }
    }
}

class GameReportIsGenerated (source: Any?, val report : GameReport) : ApplicationEvent(source)

class GameReport (val hostingTeam : TeamName, val visitingTeam : TeamName) {

    var scores: List<Score> = emptyList()
    var lineOuts: List<LineOut> = emptyList()
    var scrums: List<Scrum> = emptyList()

    var halfTimeScores : Map<TeamName, Int> = hashMapOf()
    var endScores : Map<TeamName, Int> = hashMapOf()

    fun addNewScore(score: Score) {
        this.scores += score
    }

    fun addScrum(scrum: Scrum) {
        this.scrums += scrum
    }

    fun addLineOut(lineOut: LineOut) {
        this.lineOuts += lineOut
    }

    fun determineHalfTimeScore() {
        this.halfTimeScores = this.scores.getGameScore(this.hostingTeam, this.visitingTeam)
    }

    fun determineFinalScore() {
        this.endScores = this.scores.getGameScore(this.hostingTeam, this.visitingTeam)
    }

}
