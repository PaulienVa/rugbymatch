package com.paulienvanalst.rugbymatch.game

import com.paulienvanalst.rugbymatch.events.FinishGame
import com.paulienvanalst.rugbymatch.events.ScoringEvent
import com.paulienvanalst.rugbymatch.events.StartGame
import com.paulienvanalst.rugbymatch.team.TeamName
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEventPublisher
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GameController {
    private val logger = LogManager.getLogger(GameController::class.java)

    @Autowired
    private lateinit var publisher : ApplicationEventPublisher

    @GetMapping("/")
    @CrossOrigin(origins = ["http://localhost:4200"])
    fun home(): String {
        return "Welcome to this awesome workshop!"
    }

    @GetMapping("/start-game")
    @CrossOrigin(origins = ["http://localhost:4200"])
    fun start(): Response {
        logger.info("Publishing event!")
        return try {
            publisher.publishEvent(StartGame(this, TeamName.RC_TOULON, TeamName.WASPS))
            Response(200, "The Game was started", Teams(TeamName.RC_TOULON, TeamName.WASPS))
        } catch(e: RuntimeException) {
            Response(500, "Oops an error occurred ${e.message}", null)
        }
    }

    @GetMapping("/try")
    @CrossOrigin(origins = ["http://localhost:4200"])
    fun tryToulon(): String {
        logger.info("Publishing try event!")

        // todo implement in ex 3
        return try {
            publisher.publishEvent(ScoringEvent(this, Type.TRY, TeamName.RC_TOULON))
            "Toulon scored a try"
        } catch(e: RuntimeException) {
            "Oops an error occurred ${e.message}"
        }
    }

    @GetMapping("/end-game")
    @CrossOrigin(origins = ["http://localhost:4200"])
    fun end(): Response {
        logger.info("Publishing event!")
        return try {
            publisher.publishEvent(FinishGame(this))
            Response(200, "The Game was started", ScoringBoard())
        } catch(e: RuntimeException) {
            Response(500, "Oops an error occurred ${e.message}", null)
        }
    }
}

data class Response(val code: Int, val message: String, val body: Any?)