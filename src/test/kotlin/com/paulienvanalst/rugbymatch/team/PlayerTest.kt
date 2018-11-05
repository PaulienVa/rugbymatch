package com.paulienvanalst.rugbymatch.team

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.notNullValue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PlayerTest {
    @Nested
    @DisplayName("Ex 1a and 1b: tests for checking Player Class after conversion to Kotlin")
    inner class PlayerClassTest {
        private val prop = Position.LOOSEHEAD_PROP
        private val player = Player (prop, 1)

        private val displayedPlayer = "Player(position=$prop, backNumber=1)"
        @Test
        fun `A player can be made`() {
            assertThat(player, `is`(notNullValue()))
        }

        @Test
        fun `The position and the back number of the player can be retrieved`() {
            assertThat(player.position, `is`(prop))
            assertThat(player.backNumber, `is`(1))
        }

        @Test
        fun `A player will be displayed conform the regular display rules`() {
            assertThat(player.toString(), `is`(displayedPlayer))
        }

        @Test
        fun `A player with same position and back number is just the same player`() {
            val otherPlayer = Player(Position.LOOSEHEAD_PROP, 1)
            assertThat(player, `is`(otherPlayer))
        }

        @Test
        fun `A player with same position and same back number  has the same unique hash code`() {
            val otherPlayer = Player(Position.LOOSEHEAD_PROP, 1)
            assertThat(player.hashCode(), `is`(otherPlayer.hashCode()))
        }
    }


    @Nested
    @DisplayName("Ex 1c: tests for checking if player is correctly part of the starting squad")
    inner class PlayerIsStartingTest{
        @ParameterizedTest
        @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15])
        fun `A player with back number is part of the starting squad` (backNumber: Int) {
            val playerWithPosition = Player(Position.CENTER, backNumber)
            assertThat("Player with $backNumber should be part of starting squad", playerWithPosition.isStarting, `is`(true))
        }

        @ParameterizedTest
        @ValueSource(ints = [16, 17, 18, 19, 20, 21, 22])
        fun `A player with back number is not part of the starting squad` (backNumber: Int) {
            val playerWithPosition = Player(Position.CENTER, backNumber)
            assertThat("Player with $backNumber should not be part of starting squad", playerWithPosition.isStarting, `is`(false))
        }
    }
}