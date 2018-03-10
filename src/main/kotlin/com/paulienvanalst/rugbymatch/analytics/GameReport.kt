package com.paulienvanalst.rugbymatch.analytics

import com.paulienvanalst.rugbymatch.TeamName
import com.paulienvanalst.rugbymatch.events.*
import com.paulienvanalst.rugbymatch.game.*
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class GameReporter {
    private val LOG = LogManager.getLogger(GameReporter::class.java)

    @Autowired
    private lateinit var scoringBoard: ScoringBoard

    @Autowired
    private lateinit var eventPublisher: ApplicationEventPublisher

    private lateinit var gameReport : GameReport

    @EventListener
    fun startTheReport(startGame: StartGame) {
        LOG.info("start the game ${startGame.hostingTeam} vs ${startGame.visitingTeam}")
        gameReport = GameReport(startGame.hostingTeam, startGame.visitingTeam)
    }

    @EventListener
    fun halfTime(halfTime: HalfTime) {
        gameReport.setHalfTimeScore(scoringBoard.currentScore())
    }

    @EventListener
    fun endGame(finishGame: FinishGame) {
        gameReport.setFinalScore(scoringBoard.currentScore())
        eventPublisher.publishEvent(GenerateGameReport(this, this.gameReport))
    }

    @EventListener
    fun updatingReportAfterSetPiece(setPieceEvent: SetPieceEvent) {
        gameReport.addSetPieceEvents(setPieceEvent)
        if (setPieceEvent is ScrumWasPlayed) {
            this.gameReport.addScrum(setPieceEvent.setPiece as Scrum)
        } else if (setPieceEvent is LineOutWasPlayed) {
            this.gameReport.addLineOut(setPieceEvent.setPiece as LineOut)
        }
    }
}

class GenerateGameReport (source: Any?, val report : GameReport) : ApplicationEvent(source)

class GameReport (val hostingTeam : TeamName, val visitingTeam : TeamName) {

    private var lineOuts: List<LineOut> = emptyList()
    private var scrums: List<Scrum> = emptyList()
    private var setPieceEvents: List<SetPieceEvent> = emptyList()

    private var halfTimeScores : GameScore = GameScore(hostingTeam to 0, visitingTeam to 0)
    private var endScores : GameScore = GameScore(hostingTeam to 0, visitingTeam to 0)


    fun addSetPieceEvents(setPieceEvent: SetPieceEvent) {
        this.setPieceEvents += setPieceEvent
    }
    fun addScrum(scrum: Scrum) {
        this.scrums += scrum
    }

    fun addLineOut(lineOut: LineOut) {
        this.lineOuts += lineOut
    }

    fun setHalfTimeScore(gameScore: GameScore) {
        this.halfTimeScores = gameScore
    }

    fun setFinalScore(gameScore: GameScore) {
        this.endScores = gameScore
    }

    fun format() : String {
        return """
            --------------------------------------------------------------------------------
                        The game ended with the score of ${this.endScores}.
            --------------------------------------------------------------------------------
            --------------------------------------------------------------------------------
             The half-time score was: ${halfTimeScores}

            ********* Line-outs *********
            We got ${lineOuts.size} line outs.

            ${lineOutReport(hostingTeam)}
            ${lineOutReport(visitingTeam)}

            ********* Scrums *********
            We got ${scrums.size} scrums.

            ${scrumReport(hostingTeam)}
            ${scrumReport(visitingTeam)}



            """"
    }

    private fun lineOutReport(teamName: TeamName): String {
        return """--------- $teamName ---------
                 $teamName conserved the ball in ${this.setPieceEvents.lineOutEvents().wonBy(teamName).size} line-outs
                 and lost the ball in ${this.setPieceEvents.lineOutEvents().lostBy(teamName).size} line-outs
                 """
    }

    private fun scrumReport(teamName: TeamName): String {
        return """--------- $teamName ---------
                 $teamName conserved the ball in ${this.setPieceEvents.scrumEvents().wonBy(teamName).size} scrums
                 and lost the ball in ${this.setPieceEvents.scrumEvents().lostBy(teamName).size} scrums
                 """
    }

}
