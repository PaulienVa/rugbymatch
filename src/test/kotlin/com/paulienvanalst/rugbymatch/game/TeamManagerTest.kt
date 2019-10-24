package com.paulienvanalst.rugbymatch.game

import com.paulienvanalst.rugbymatch.events.GameAnnounced
import com.paulienvanalst.rugbymatch.events.SquadAnnounced
import com.paulienvanalst.rugbymatch.team.Player
import com.paulienvanalst.rugbymatch.team.Position
import com.paulienvanalst.rugbymatch.team.TeamName.RC_TOULON
import com.paulienvanalst.rugbymatch.team.TeamName.WASPS
import io.mockk.mockkClass
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.context.ApplicationEventPublisher
import java.time.LocalDate

class TeamManagerTest {

    private var applicationEventPublisher = mockkClass(ApplicationEventPublisher::class)
    private var substitutionRepository = mockkClass(SubstitutionRepository::class)

    private val teamManager = TeamManager(applicationEventPublisher, substitutionRepository)

    @Test
    @DisplayName("Ex 4a: Make sure that when the game is announced the two teams are registered")
    fun `when a game is announced the team manager registers the two team` () {
        teamManager.start(GameAnnounced(this, RC_TOULON, WASPS, LocalDate.now()))

        val (rcToulon, wasps) = teamManager.currentCompositionOfTeams()

        assertThat(rcToulon.name, `is`(RC_TOULON))
        assertThat(wasps.name, `is`(WASPS))
    }

    @Test
    @DisplayName("Ex 4b: Make sure the team manager registers the players when the hosting squad is announced")
    fun `when the hosting squad is announced the team manager registers the players of both teams` () {
        teamManager.start(GameAnnounced(this, RC_TOULON, WASPS, LocalDate.now()))
        teamManager.squadAnnounced(SquadAnnounced(this, playersToulon(), RC_TOULON))

        val (rcToulon, wasps) = teamManager.currentCompositionOfTeams()

        assertThat(rcToulon.name, `is`(RC_TOULON))
        assertThat(rcToulon.players, `is`(playersToulon()))
        assertThat(wasps.name, `is`(WASPS))
        assertThat(wasps.players, `is`(listOf()))
    }

    @Test
    @DisplayName("Ex 4b: Make sure the team manager registers the players when the visiting squad is announced")
    fun `when the visting squads are announced the team manager registers the players of both teams` () {
        teamManager.start(GameAnnounced(this, RC_TOULON, WASPS, LocalDate.now()))
        teamManager.squadAnnounced(SquadAnnounced(this, playersWasps(), WASPS))

        val (rcToulon, wasps) = teamManager.currentCompositionOfTeams()

        assertThat(rcToulon.name, `is`(RC_TOULON))
        assertThat(rcToulon.players, `is`(listOf()))
        assertThat(wasps.name, `is`(WASPS))
        assertThat(wasps.players, `is`(playersWasps()))

    }

    private fun playersToulon(): List<Player> {
        return listOf(
                Player(Position.LOOSEHEAD_PROP, 1),
                Player(Position.HOOKER, 1),
                Player(Position.TIGHTHEAD_PROP, 3),
                Player(Position.LOCK, 4),
                Player(Position.LOCK, 5)
        )
    }
    private fun playersWasps(): List<Player> {
        return listOf(
                Player(Position.WING, 11),
                Player(Position.CENTER, 10),
                Player(Position.SCRUM_HALF, 9),
                Player(Position.LOCK, 4),
                Player(Position.LOCK, 5)
        )
    }

}