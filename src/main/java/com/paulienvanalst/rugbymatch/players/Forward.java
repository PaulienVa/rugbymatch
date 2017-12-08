package com.paulienvanalst.rugbymatch.players;

import com.google.common.base.Objects;

public class Forward implements Player {

    private final Team team;
    private final Position position;

    public Forward(final Team team, final Position position) {
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
        return Position.getForwards().contains(this.position);
    }

    public void scrum() {
        System.out.println("Let's scrym !");
    }

    @Override
    public String toString() {
        return "Forward{" +
                "team=" + team +
                ", position=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forward forward = (Forward) o;
        return team == forward.team &&
                position == forward.position;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(team, position);
    }
}
