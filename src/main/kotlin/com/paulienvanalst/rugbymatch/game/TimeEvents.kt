package com.paulienvanalst.rugbymatch.game

import com.paulienvanalst.rugbymatch.TeamName
import org.springframework.context.ApplicationEvent

class GameIsStarted(source: Any?, val hostingTeam: TeamName, val visitingTeam: TeamName) : ApplicationEvent(source)
class HalfTime(source: Any?) : ApplicationEvent(source)
class GameIsFinished(source: Any?) : ApplicationEvent(source)