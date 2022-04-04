package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class GumTest {

    @Test
    public void getSound_returns_glug_glug_yum() {
        Gum sut = new Gum();
        String test = sut.getSound();

        Assert.assertEquals("Chew Chew, Yum!", test);
    }

}
