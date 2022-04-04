package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class ChipTest {

    @Test
    public void getSound_returns_crunch_crunch_yum() {
        Chip sut = new Chip();
        String test = sut.getSound();

        Assert.assertEquals("Crunch Crunch, Yum!", test);
    }
}
