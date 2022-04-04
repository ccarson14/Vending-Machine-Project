package com.techelevator;

import java.util.Scanner;

public class UI {

    Scanner userInput = new Scanner(System.in);

    Inventory inventory = new Inventory();
    Money money = new Money();

    public void mainMenu(){

        inventory.createInventory();
        mainMenuOptions();
        String menuChoice = userInput.nextLine();

        while(!menuChoice.equals("3")){

            if(menuChoice.equals("1")){
                inventory.displayInventory();
            }
            if(menuChoice.equals("2")){
                purchaseMenuOptions();
                purchaseMenu();
            }
            System.out.print("\n");
            mainMenuOptions();
            menuChoice = userInput.nextLine();
        }
        System.out.println();
        System.out.println("Thank you for using Vendo-Matic 800. Goodbye!");
        System.exit(0);
    }

    public void purchaseMenu(){

        String purchaseMenuChoice = userInput.nextLine();

        while (!purchaseMenuChoice.equals("3")){

            if(purchaseMenuChoice.equals("1")){
                money.feedMoney();
                System.out.println("Current money provided: $" + String.format("%.2f", money.getCurrentMoneyProvided()));
            }
            if(purchaseMenuChoice.equals("2")){
                inventory.displayInventory();
                System.out.println("Enter the code of the item: ");
                System.out.print(">> ");
                String slotIdentifier = userInput.nextLine();
                slotIdentifier = slotIdentifier.toUpperCase();
                inventory.purchase(slotIdentifier, money);
            }

            System.out.print("\n");
            purchaseMenuOptions();
            purchaseMenuChoice = userInput.nextLine();
        }
        money.giveChange();
        System.out.println("\nCurrent money provided: $" + String.format("%.2f", money.getCurrentMoneyProvided()));
    }

    public void mainMenuOptions() {
        System.out.println();
        System.out.println("(1) Display vending machine items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");
        System.out.print(">> ");
    }
    public void purchaseMenuOptions(){
        System.out.println();
        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");
        System.out.println("\nCurrent money provided: $" + String.format("%.2f", money.getCurrentMoneyProvided()));
        System.out.print(">> ");
    }


}
