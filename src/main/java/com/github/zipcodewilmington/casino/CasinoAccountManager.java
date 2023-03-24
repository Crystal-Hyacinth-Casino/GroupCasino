package com.github.zipcodewilmington.casino;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
import com.github.zipcodewilmington.Casino;

import java.util.ArrayList;
import java.util.Scanner;

public class CasinoAccountManager {
    public static final String ANSI_RED = "\u001B[31m";
    static Scanner input = new Scanner(System.in);




    public static ArrayList<CasinoAccount> accountList = new ArrayList<CasinoAccount>();


    public static CasinoAccount createAccount() {

        CasinoAccount newAccount = null;

        System.out.println("Please pick a username");
        String user = input.next();

        System.out.println(ANSI_RED + "Please input a password");
        String pass = input.next();

        boolean x = true;

        while (x) {
            int bal = Casino.getNumber(ANSI_RED + "How much do you want to deposit?"); // method asks how much a user wants to add

            if (bal > 0) {
                newAccount = new CasinoAccount(user, pass, bal);


                x = false;
            } else {
                System.out.println("Sorry you don't have enough money");
            }
        }


        System.out.println("Your account has been created");

        Casino.delay();

        System.out.println("Returning to Main Menu");

        Casino.delay();


        //console.mainMenu();


        accountList.add(newAccount);
        System.out.println(accountList);


        return newAccount;

    }
}
