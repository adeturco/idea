package com.company;
import java.util.*;
import java.util.Scanner;


public class BankMachine {
    public int money;

    public int readPin() {
        System.out.println("Enter your pin: ");
        Scanner sc = new Scanner(System.in);
        return(sc.nextInt());
    }

    private boolean goodPIN(int pin) {
        return((pin == 1234) ? true : false);
    }

    public void checkPin() {
        int pin = readPin();
        if (!goodPIN(pin)) {
            System.out.println("Sorry, incorrect PIN. Want to try again? Y/N: ");
            Scanner sc = new Scanner(System.in);
            char choice = sc.nextLine().charAt(0);
            if(choice == 'Y') {
                checkPin();
            }
            else {
                System.exit(0);
            }
        }
    }

    public void setMoney(int amount) {
        Date d = new Date();
        if (amount > 0) {
            money = this.money + amount;
            System.out.println(d + " Your transfer: " + amount + ". You have now " + money + " in your bank account.");
        } else {
            System.out.println(d + " suspicious amount...");
        }
    }

    public int withdrawMoney(int amount) {
        Date d = new Date();
        if (amount <= money) {
            money -= amount;
            System.out.println(d + " withdraw " + amount);
            return money;
        }
        else {
            System.out.println("Insufficient funds. Choose smaller amount.");
        }
        return 0;
    }

    public int showBalance() {
        System.out.println("Do you want to see your balance? Y/N: ");
        Scanner sc = new Scanner(System.in);
        char c = sc.nextLine().charAt(0);

        if(c == 'Y') {
            System.out.println("You have: " + money + " in your bank account.");
        }
        else if(c == 'N') {
        }
        else {
            System.out.println("Wrong symbol. Press 'Y' or 'N'");
        }
        return money;
    }

    public void askChoice() {
        Scanner sc = new Scanner(System.in);
        char choice = sc.nextLine().charAt(0);

        if(choice == 'W') {
            checkPin();
            System.out.println("How much money? ");
            int mn = sc.nextInt();
            withdrawMoney(mn);
            showBalance();
        }

        else if(choice == 'T') {
            checkPin();
            System.out.println("How much money? ");
            int mn = sc.nextInt();
            setMoney(mn);
        }

        else if(choice == 'B') {
            checkPin();
            System.out.println("You have: " + money + " in your bank account.");
        }
        else {
            System.out.println("Wrong symbol! Press 'T' or 'W' or 'B'");
        }

    }
}
