package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class BeverageTest {

    @Test
    public void getSound_returns_glug_glug_yum() {
        Beverage sut = new Beverage();
        String test = sut.getSound();

        Assert.assertEquals("Glug Glug, Yum!", test);
    }
}
