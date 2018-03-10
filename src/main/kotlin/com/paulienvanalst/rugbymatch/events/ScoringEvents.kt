package com.paulienvanalst.rugbymatch.events

import com.paulienvanalst.rugbymatch.TeamName
import com.paulienvanalst.rugbymatch.game.*
import org.springframework.context.ApplicationEvent

class ScoringEvent(source: Any?, val type: Type, val team: TeamName) : ApplicationEvent(source)