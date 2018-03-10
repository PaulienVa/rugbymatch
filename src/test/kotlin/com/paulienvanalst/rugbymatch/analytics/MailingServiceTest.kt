package com.paulienvanalst.rugbymatch.analytics

import com.paulienvanalst.rugbymatch.Application
import com.paulienvanalst.rugbymatch.TeamName
import com.paulienvanalst.rugbymatch.game.StartGame
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.junit.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationEventPublisher
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = arrayOf(Application::class))
class MailingServiceIT {

    @Autowired
    private lateinit var gameReporter: GameReporter

    @Autowired
    private lateinit var mailingService: MailingService

    @Autowired
    private lateinit var eventPublisher: ApplicationEventPublisher

    @Test
    fun `generate a mail after the game` () {
        eventPublisher.publishEvent(StartGame(this, TeamName.RC_TOULON, TeamName.WASPS))
        assertThat(true, `is`(true))
    }


}