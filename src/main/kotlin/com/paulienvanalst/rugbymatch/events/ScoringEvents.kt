package com.paulienvanalst.rugbymatch.events

import com.paulienvanalst.rugbymatch.Team
import com.paulienvanalst.rugbymatch.game.Score
import com.paulienvanalst.rugbymatch.game.Transformation
import com.paulienvanalst.rugbymatch.game.Try
import org.springframework.context.ApplicationEvent

open class ScoringEvent(source: Any?, val score: Score) : ApplicationEvent(source)

class TryIsScored(source: Any?, val tryS : Try) : ScoringEvent(source, tryS)
class TryIsTransformed(source: Any?, val transformedTry: Transformation) : ScoringEvent(source, transformedTry)