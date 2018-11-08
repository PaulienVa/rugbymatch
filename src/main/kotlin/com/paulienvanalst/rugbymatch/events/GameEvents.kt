package com.paulienvanalst.rugbymatch.events

import com.paulienvanalst.rugbymatch.team.Team
import org.springframework.context.ApplicationEvent

sealed class SetPieceEvent(source: Any, val setPiece: SetPiece, val winningTeam: TeamName) : ApplicationEvent(source)


