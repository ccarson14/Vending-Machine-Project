package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Product {

    public Gum(String name, BigDecimal price){
        super(name, price);
    }
    public Gum() {

    }

    @Override
    public String getSound() {
        return "Chew Chew, Yum!";
    }
}
