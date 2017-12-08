package com.paulienvanalst.rugbymatch.players;

import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;

class ForwardTest {

    @Test
    public void aForwardWillAlwaysBeAForward() {
        Forward prop = new Forward(Team.HARLEQUINS, Position.LOOSEHEAD_PROP);

        assertThat(prop.isValid(), is(true));
    }


    @Test
    public void aScrumHalfIsCertainlyNotAForward() {
        HalfBack scrumHalf = new HalfBack(Team.HARLEQUINS, Position.SCRUM_HALF);

        assertThat(scrumHalf.isValid(), is(false));
    }
}