package com.paulienvanalst.rugbymatch.game

import com.paulienvanalst.rugbymatch.TeamTestData
import com.paulienvanalst.rugbymatch.team.TeamName
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class SetPiecesTest {

    @Nested
    @DisplayName("Ex 2a: Scrum tests")
    @Disabled
    inner class ScrumTests{
        @Test
        fun `a scrum is valid when both teams have a scrum`() {
            val toulon = TeamTestData().validTeam(TeamName.RC_TOULON)
            val wasps = TeamTestData().validTeam(TeamName.WASPS)

            assertThat(Scrum(toulon, wasps).isValid(), `is`(true))
        }

        @Test
        fun `a scrum is invalid when only team in possession have a scrum`() {
            val toulon = TeamTestData().validTeam(TeamName.RC_TOULON)
            val wasps = TeamTestData().inValidTeam(TeamName.WASPS)

            assertThat(Scrum(toulon, wasps).isValid(), `is`(false))
        }

        @Test
        fun `a scrum is invalid when only the opponent team have a scrum`() {
            val toulon = TeamTestData().inValidTeam(TeamName.RC_TOULON)
            val wasps = TeamTestData().validTeam(TeamName.WASPS)

            assertThat(Scrum(toulon, wasps).isValid(), `is`(false))
        }
    }

    @Nested
    @DisplayName("Ex 2b: Line-out tests")
    @Disabled
    inner class LineOutTests {
        @ParameterizedTest
        @ValueSource(ints = [5, 8])
        fun `a line out is valid when both team have the same amount of players`(nrPlayers: Int) {
            val toulon = TeamTestData().validTeam(TeamName.RC_TOULON)
            val wasps = TeamTestData().validTeam(TeamName.WASPS)

            assertThat(LineOut(toulon, wasps).isValid(), `is`(true))
        }


        @ParameterizedTest
        @ValueSource(ints = [5, 8])
        fun `a line out is invalid when opponent team chooses to have a different amount of players`(nrPlayers: Int) {
            val toulon = TeamTestData().validTeam(TeamName.RC_TOULON).withExtraLock()
            val wasps = TeamTestData().validTeam(TeamName.WASPS)

            assertThat(LineOut(toulon, wasps).isValid(), `is`(false))
        }
    }
}