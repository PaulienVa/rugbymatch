package com.paulienvanalst.rugbymatch.players

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.notNullValue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PlayerTest {
    private val awesomeTeam = "OpenValue"
    private val firstRow = 1
    private val player = Player(awesomeTeam, firstRow)

    private val displayedPlayer = "Player(team=$awesomeTeam, position=$firstRow)"

    @Test
    fun `A player can be made`() {
        assertThat(player.team, `is`(notNullValue()))
    }

    @Test
    fun `The team and the position of the player can be retrieved`() {
        assertThat(player.team, `is`(awesomeTeam))
        assertThat(player.position, `is`(firstRow))
    }

    @Test
    fun `A player will be displayed conform the regular display rules`() {
        assertThat(player.toString(), `is`(displayedPlayer))
    }

    @Test
    fun `A player with same team and position is just the same player`() {
        val otherPlayer = Player(awesomeTeam, firstRow)
        assertThat(player, `is`(otherPlayer))
    }

    @Test
    fun `A player with same team and position is has the same unique hash code`() {
        val otherPlayer = Player(awesomeTeam, firstRow)
        assertThat(player.hashCode(), `is`(otherPlayer.hashCode()))
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15])
    fun `A player with position is part of the starting squad` (position: Int) {
        val playerWithPosition = Player(awesomeTeam, position)
        assertThat("Player with $position should be part of starting squad", playerWithPosition.isStarting, `is`(true))
    }

    @ParameterizedTest
    @ValueSource(ints = [16, 17, 18, 19, 20, 21, 22])
    fun `A player with position is not part of the starting squad` (position: Int) {
        val playerWithPosition = Player(awesomeTeam, position)
        assertThat("Player with $position should not be part of starting squad", playerWithPosition.isStarting, `is`(false))
    }


}