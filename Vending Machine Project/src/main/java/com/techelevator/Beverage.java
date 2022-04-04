package com.techelevator;

import java.math.BigDecimal;

public class Beverage extends Product {

    public Beverage(String name, BigDecimal price){
        super(name, price);
    }

    public Beverage() {

    }

    @Override
    public String getSound() {
        return "Glug Glug, Yum!";
    }
}
