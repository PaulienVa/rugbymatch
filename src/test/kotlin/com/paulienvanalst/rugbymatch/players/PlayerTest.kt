package com.paulienvanalst.rugbymatch.players

import com.paulienvanalst.rugbymatch.oldfashioned.Player
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.notNullValue
import org.junit.jupiter.api.Test

class PlayerTest {
    private val awesomeTeam = "OpenValue"
    private val firstRow = 1
    private val player = Player(awesomeTeam, firstRow)

    private val displayedPlayer = "Player{team='$awesomeTeam', position=$firstRow}"

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


}