package com.paulienvanalst.rugbymatch.game

import com.paulienvanalst.rugbymatch.TeamName
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

class ScoreTest {
    val hostingTeam =
    val visitingTeam = TeamName.WASPS

    @Test
    fun `a try is added to an initial scoring board`() {
        val toulon =
        assertThat(Score( TeamName.RC_TOULON, 0)  + Try(hostingTeam), `is`(Score(hostingTeam, 5)))
    }
}