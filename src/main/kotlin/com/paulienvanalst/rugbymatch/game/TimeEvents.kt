package com.paulienvanalst.rugbymatch.game

import com.paulienvanalst.rugbymatch.TeamName
import org.springframework.context.ApplicationEvent

class StartGame(source: Any?, val hostingTeam: TeamName, val visitingTeam: TeamName) : ApplicationEvent(source!!)
class HalfTime(source: Any?) : ApplicationEvent(source!!)
class FinishGame(source: Any?) : ApplicationEvent(source!!)