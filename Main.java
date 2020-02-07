package com.company;
        import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BankMachine machine = new BankMachine();
        machine.money = 15000;
        System.out.println("Hello, if you want to transfer some money to your account press 'T', if you want to make a withdrawal press 'W', if you just want to see your balance press'B'.");
        machine.askChoice();
    }
}