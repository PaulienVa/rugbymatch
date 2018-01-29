
package com.paulienvanalst.rugbymatch.players

enum class Position {
    LOOSEHEAD_PROP,
    HOOKER,
    TIGHTHEAD_PROP,
    LOCK,
    FLANKER,
    NR8,
    SCRUM_HALF,
    FLY_HALF,
    CENTER,
    WING,
    FULLBACK,
    ;

    companion object {
        fun getForwards() : List<Position> {
            return listOf(LOOSEHEAD_PROP, HOOKER, TIGHTHEAD_PROP, LOCK, FLANKER, NR8)
        }

        fun getHalfBacks() : List<Position> {
            return listOf(SCRUM_HALF, FLY_HALF)
        }

        fun getBacks() : List<Position> {
            return listOf(CENTER, WING, FULLBACK)
        }
    }

}