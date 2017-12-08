package com.paulienvanalst.rugbymatch.players;

import com.google.common.base.Objects;

public class HalfBack implements Player {

    private final Team team;
    private final Position position;

    public HalfBack(Team team, Position position) {
        this.team = team;
        this.position = position;
    }

    public Team getTeam() {
        return this.team;
    }

    public Position getPosition() {
        return this.position;
    }

    public boolean isValid() {
        return Position.getBacks().contains(this.position);
    }

    @Override
    public String toString() {
        return "HalfBack{" +
                "team=" + team +
                ", position=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HalfBack halfBack = (HalfBack) o;
        return team == halfBack.team &&
                position == halfBack.position;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(team, position);
    }
}
