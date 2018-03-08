package com.paulienvanalst.rugbymatch.events

import com.paulienvanalst.rugbymatch.game.LineOut
import com.paulienvanalst.rugbymatch.game.Scrum
import com.paulienvanalst.rugbymatch.game.SetPiece
import org.springframework.context.ApplicationEvent

open class SetPieceEvent(source: Any?, val setPiece: SetPiece) : ApplicationEvent(source)

class ScrumWasPlayed(source: Any?,  val scrum: Scrum) : SetPieceEvent(source, scrum)
class LineOutWasPlayed(source: Any?, val lineOut: LineOut) : SetPieceEvent(source, lineOut)