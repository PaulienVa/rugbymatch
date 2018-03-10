
package com.paulienvanalst.rugbymatch.team

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
    FULLBACK;

    fun isFrontRow() : Boolean = this == LOOSEHEAD_PROP || this == TIGHTHEAD_PROP || this == HOOKER


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