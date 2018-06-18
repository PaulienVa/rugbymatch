package com.paulienvanalst.rugbymatch.game

import com.paulienvanalst.rugbymatch.team.NotImplementedException


interface SetPiece {
   //todo to implement

    fun isValid() : Boolean
}

data class Scrum(val a: Object, val b: Object) : SetPiece {

    /**
     * A scrum is valid when both teams participating have a scrum
     */
    override fun isValid(): Boolean {
        throw NotImplementedException()
    }
}

/**
 * A lineout is valid when both team participating have the same number of players playing the line-out
 */

data class LineOut(val a: Object, val b: Object) : SetPiece {

    override fun isValid(): Boolean {
        throw NotImplementedException()
    }
}
