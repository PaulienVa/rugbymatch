package com.paulienvanalst.rugbymatch.game

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

    @GetMapping("/game")
    fun play(): String {
        logger.error("Publishing event!")
        publisher.publishEvent(KickOff(this, "STADE", 9))
        return "Hello Rugby World!"
    }
}