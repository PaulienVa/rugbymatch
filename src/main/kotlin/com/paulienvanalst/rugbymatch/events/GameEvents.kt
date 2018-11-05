package com.paulienvanalst.rugbymatch.events

import com.paulienvanalst.rugbymatch.team.Team
import org.springframework.context.ApplicationEvent

sealed class SetPieceEvent(source: Any, val teamThrowingIn: Team, val otherTeam: Team) : ApplicationEvent(source)


