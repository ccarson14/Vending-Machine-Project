package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class InventoryTest {
    private Inventory sut;

    @Before
    public void setup() {
        sut = new Inventory();
    }

    @Test
    public void createInventory_adds_key() {
        Map<String, List<Product>> test = sut.createInventory();
        boolean keyTest = test.containsKey("D4");

        Assert.assertTrue("The key was not created in the inventory.", keyTest);
    }

    @Test
    public void createInventory_key_has_correct_value() {
        Map<String, List<Product>> test = sut.createInventory();
        String valueTest = test.get("A2").subList(0, 1).toString();

        Assert.assertEquals("[Stackers: $1.45, ]", valueTest);
    }

    @Test
    public void createInventory_makes_value_of_five_items() {
        Map<String, List<Product>> test = sut.createInventory();
        int testSize = test.get("D4").size();

        Assert.assertEquals(5, testSize);
    }

    @Test
    public void returnMessage_returns_sound() {
        String test = sut.returnMessage("C");

        Assert.assertEquals("Glug Glug, Yum!", test);
    }

    @Test
    public void removeItem_removes_one_product_from_map_value(){
        Map<String, List<Product>> test = sut.createInventory();
        test.get("B3").remove(1);
        int productSize = test.get("B3").size();

        Assert.assertEquals(4, productSize);
    }
}
