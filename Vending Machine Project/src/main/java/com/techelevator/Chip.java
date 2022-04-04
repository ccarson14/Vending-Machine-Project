package com.techelevator;

import java.math.BigDecimal;

public class Chip extends Product {

    public Chip(String name, BigDecimal price){
        super(name, price);
    }

    public Chip() {

    }

    @Override
    public String getSound() {
        return "Crunch Crunch, Yum!";
    }
}
