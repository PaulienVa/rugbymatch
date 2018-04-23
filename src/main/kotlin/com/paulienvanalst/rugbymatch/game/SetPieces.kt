package com.paulienvanalst.rugbymatch.game


interface SetPiece {
   //todo to implement

    fun isValid() : Boolean
}

data class Scrum() : SetPiece {

    /**
     * A scrum is valid when both teams participating have a scrum
     */
    override fun isValid(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

/**
 * A lineout is valid when both team participating have the same number of players playing the line-out
 */

data class LineOut() : SetPiece {

    override fun isValid(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
