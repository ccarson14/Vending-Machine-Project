package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class Inventory {
    Map<String, List<Product>> inventoryLevels = new LinkedHashMap<>();
    Log write = new Log();

    public Map<String, List<Product>> createInventory() {
        File file = new File("vendingmachine.csv");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] inventoryArray = line.split("\\|");

                if (inventoryArray[0].startsWith("A")) {
                    List<Product> productInfo = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        BigDecimal price = new BigDecimal(inventoryArray[2]);
                        Chip chip = new Chip(inventoryArray[1], price);
                        productInfo.add(chip);

                    }
                    inventoryLevels.put(inventoryArray[0], productInfo);
                }
                if (inventoryArray[0].startsWith("B")) {
                    List<Product> productInfo = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        BigDecimal price = new BigDecimal(inventoryArray[2]);
                        Candy candy = new Candy(inventoryArray[1], price);
                        productInfo.add(candy);
                    }
                    inventoryLevels.put(inventoryArray[0], productInfo);
                }
                if (inventoryArray[0].startsWith("C")) {
                    List<Product> productInfo = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        BigDecimal price = new BigDecimal(inventoryArray[2]);
                        Beverage beverage = new Beverage(inventoryArray[1], price);
                        productInfo.add(beverage);
                    }
                    inventoryLevels.put(inventoryArray[0], productInfo);
                }
                if (inventoryArray[0].startsWith("D")) {
                    List<Product> productInfo = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        BigDecimal price = new BigDecimal(inventoryArray[2]);
                        Gum gum = new Gum(inventoryArray[1], price);
                        productInfo.add(gum);
                    }
                    inventoryLevels.put(inventoryArray[0], productInfo);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist.");
            System.exit(1);
        }
        return inventoryLevels;
    }

    public void displayInventory() {
        for (Map.Entry<String, List<Product>> entry : inventoryLevels.entrySet()) {
            String slotIdentifier = entry.getKey();
            String value = entry.getValue().subList(0, 1).toString().replace("[", "").replace("]", "");
            System.out.println(slotIdentifier + " | " + value + entry.getValue().size());
        }
    }

    public void purchase(String slotIdentifier, Money money) {

        if(!inventoryLevels.containsKey(slotIdentifier)) {
            System.out.println("Product choice not an option. Please choose again.");
        }
        if(inventoryLevels.containsKey(slotIdentifier)) {

            if(inventoryLevels.get(slotIdentifier).size() == 0) {
                System.out.println("Item out of stock. Sorry :(");
            }
            if(inventoryLevels.get(slotIdentifier).size() > 0) {
                Product tester = inventoryLevels.get(slotIdentifier).get(1);
                String test = tester.toString().replace(", ", "");
                String[] split = test.split(": \\$");
                String name = split[0];
                double price = Double.parseDouble(split[1]);

                if (money.getCurrentMoneyProvided() >= price) {
                    double startBalance = money.getCurrentMoneyProvided();
                    double endBalance = startBalance - price;
                    money.setCurrentMoneyProvided(endBalance);
                    Product nameCost = inventoryLevels.get(slotIdentifier).get(1);

                    System.out.println();
                    System.out.println(returnMessage(slotIdentifier));
                    System.out.println(nameCost + " $" + String.format("%.2f", money.getCurrentMoneyProvided()));

                    write.writeLog(name + " " + slotIdentifier, startBalance, endBalance);

                    removeItem(slotIdentifier);
                }
                else {
                    System.out.println("Insufficient funds.");
                }
            }
        }
    }

    public String returnMessage(String slotIdentifier) {
        if(slotIdentifier.startsWith("A")) {
            Chip chip = new Chip();
            return chip.getSound();
        }
        if(slotIdentifier.startsWith("B")) {
            Candy candy = new Candy();
            return candy.getSound();
        }
        if(slotIdentifier.startsWith("C")) {
            Beverage beverage = new Beverage();
            return beverage.getSound();
        }
        if(slotIdentifier.startsWith("D")) {
            Gum gum = new Gum();
            return gum.getSound();
        }
        return "";
    }

    public void removeItem(String slotIdentifier) {
        inventoryLevels.get(slotIdentifier).remove(1);
    }
}


