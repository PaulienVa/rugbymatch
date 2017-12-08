package com.paulienvanalst.rugbymatch.players;


public interface Player {
    Team getTeam();

    Position getPosition();

    boolean isValid();
}
