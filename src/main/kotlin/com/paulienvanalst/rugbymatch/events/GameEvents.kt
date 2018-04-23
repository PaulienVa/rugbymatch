package com.paulienvanalst.rugbymatch.events

import org.springframework.context.ApplicationEvent
import com.paulienvanalst.rugbymatch.team.TeamName
import com.paulienvanalst.rugbymatch.game.*

sealed class SetPieceEvent(source: Any?, val someArgs: Any) : ApplicationEvent(source)


