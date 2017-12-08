package com.paulienvanalst.rugbymatch.players;

import java.util.Arrays;
import java.util.List;

public enum Position {
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

    public static List<Position> getForwards () {
        return Arrays.asList(LOOSEHEAD_PROP, HOOKER, TIGHTHEAD_PROP, LOCK, FLANKER, NR8);
    }

    public static List<Position> getHalfBacks() {
        return Arrays.asList(SCRUM_HALF, FLY_HALF);
    }

    public static List<Position> getBacks() {
        return Arrays.asList(CENTER, WING, FULLBACK);
    }
}
