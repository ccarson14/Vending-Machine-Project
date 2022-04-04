package com.techelevator;

import java.util.*;

public class Money {
    private double currentMoneyProvided;
    Log write = new Log();

    public double getCurrentMoneyProvided() {
        return currentMoneyProvided;
    }
    public void setCurrentMoneyProvided(double currentMoneyProvided) {
        this.currentMoneyProvided = currentMoneyProvided;
    }

    public void feedMoney() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter the whole dollar amount you would like to deposit: ");
        System.out.print(">> ");
        int depositAmount = Integer.parseInt(userInput.nextLine());
        if (depositAmount > 0) {
            currentMoneyProvided += depositAmount;
            write.writeLog("FEED MONEY: ", depositAmount, currentMoneyProvided);
            } else {
                System.out.println("Deposit must be a positive whole number.");
            }
    }

    public void giveChange() {
        double startBalance = Math.round(currentMoneyProvided * 100) / 100;
        double changeOwed = currentMoneyProvided * 100;
        int quarters = (int) (changeOwed / 25);
        changeOwed -= (quarters * 25);
        int dimes = (int) (changeOwed / 10);
        changeOwed -= (dimes * 10);
        int nickles = (int) (changeOwed / 5);
        changeOwed -= (nickles * 5);

        System.out.println();
        System.out.println("CHANGE: ");
        if (quarters > 0) {
            System.out.println("Quarters: " + quarters);
        } if (dimes > 0) {
            System.out.println("Dimes: " + dimes);
        } if(nickles > 0) {
            System.out.println("Nickles: " + nickles);
        }
        write.writeLog("GIVE CHANGE: ", startBalance, changeOwed);

        currentMoneyProvided = 0;
    }

}





