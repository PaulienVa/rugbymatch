package com.paulienvanalst.rugbymatch.events

import com.paulienvanalst.rugbymatch.TeamName
import com.paulienvanalst.rugbymatch.game.LineOut
import com.paulienvanalst.rugbymatch.game.Scrum
import com.paulienvanalst.rugbymatch.game.SetPiece
import com.paulienvanalst.rugbymatch.game.Type
import org.springframework.context.ApplicationEvent

//Ex 3 to implement
open class SetPieceEvent(source: Any?, val setPiece: SetPiece) : ApplicationEvent(source)

class ScrumWasPlayed(source: Any?,  val scrum: Scrum) : SetPieceEvent(source, scrum)
class LineOutWasPlayed(source: Any?, val lineOut: LineOut) : SetPieceEvent(source, lineOut)

class ScoringEvent(source: Any?, val type: Type, val team: TeamName) : ApplicationEvent(source)