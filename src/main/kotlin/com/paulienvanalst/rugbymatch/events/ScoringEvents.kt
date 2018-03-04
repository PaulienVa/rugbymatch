package com.paulienvanalst.rugbymatch.events

import com.paulienvanalst.rugbymatch.Team
import com.paulienvanalst.rugbymatch.game.*
import org.springframework.context.ApplicationEvent

open class ScoringEvent(source: Any?, val score: Score) : ApplicationEvent(source)

class TryIsScored(source: Any?, val scoredTry : Try) : ScoringEvent(source, scoredTry)
class TryIsTransformed(source: Any?, val transformedTry: Transformation) : ScoringEvent(source, transformedTry)
class PenalityIsScored(source: Any?, val scoredPenalty: Penalty) : ScoringEvent(source, scoredPenalty)
class DropGoalIsScored(source: Any?, val scoredDropGoal: DropGoal) : ScoringEvent(source, scoredDropGoal)