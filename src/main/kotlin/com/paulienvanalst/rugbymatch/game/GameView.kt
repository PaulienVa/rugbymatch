package com.paulienvanalst.rugbymatch.game

import com.paulienvanalst.rugbymatch.TeamName
import com.paulienvanalst.rugbymatch.events.FinishGame
import com.paulienvanalst.rugbymatch.events.ScoringEvent
import com.paulienvanalst.rugbymatch.events.StartGame
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEventPublisher
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GameController {
    private val logger = LogManager.getLogger(GameController::class.java)

    @Autowired
    private lateinit var  publisher : ApplicationEventPublisher


    @GetMapping("/")
    fun home(): String {
        return "Welcome to this awesome workshop!"
    }

    @GetMapping("/start-game")
    fun start(): String {
        logger.error("Publishing event!")
        return try {
            publisher.publishEvent(StartGame(this, TeamName.RC_TOULON, TeamName.WASPS))
            "The Game was started"
        } catch(e: RuntimeException) {
            "Oops an error occurred ${e.message}"
        }
    }

    @GetMapping("/try")
    fun tryToulon(): String {
        logger.error("Publishing try event!")
        return try {
            publisher.publishEvent(ScoringEvent(this, Type.TRY, TeamName.RC_TOULON))
            "Toulon scored a try"
        } catch(e: RuntimeException) {
            "Oops an error occurred ${e.message}"
        }
    }

    @GetMapping("/end-game")
    fun end(): String {
        logger.error("Publishing event!")

        return try {
            publisher.publishEvent(FinishGame(this))
            "The Game is finished"
        } catch(e: RuntimeException) {
            "Oops an error occurred ${e.message}"
        }
    }
}