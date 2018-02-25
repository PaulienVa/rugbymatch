package com.paulienvanalst.rugbymatch.oldfashioned;

import java.util.Objects;

public class Player {

    private final String team;
    private final int position;

    public Player(String team, int position) {
        this.team = team;
        this.position = position;
    }

    public String getTeam() {
        return team;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Player{" +
                "team='" + team + '\'' +
                ", position=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return position == player.position &&
                Objects.equals(team, player.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(team, position);
    }
}
