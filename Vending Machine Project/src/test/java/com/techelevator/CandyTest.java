package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CandyTest {

    @Test
    public void getSound_returns_munch_munch_yum() {
        Candy sut = new Candy();
        String test = sut.getSound();

        Assert.assertEquals("Munch Munch, Yum!", test);
    }
}
