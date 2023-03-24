package com.github.zipcodewilmington.casino.games.Klondike;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.IGamblingGame;
import com.github.zipcodewilmington.casino.games.Dice;

import java.util.ArrayList;
import java.util.Scanner;

public class Klondike extends Dice implements IGamblingGame {
    //ArrayList<Player> klondike = new ArrayList<Player>();
    Scanner scan = new Scanner(System.in);
    CasinoAccountManager CAM = new CasinoAccountManager();

    Integer chuckPlayer;
    Integer chuckDealer;
    Integer bet = 0;
    Integer highLow = -1;
    char input = 'z';

    public void playGame() {
        System.out.println("Welcome to the Klondike Table");


        System.out.println("Press any key, and we'll start ROLLING, pun intended");
        scan.nextLine();

        System.out.println("Shake.. shake.. shake, boom!");

        Casino.delay();
        //dealer rolls dice
        diceThrow(5);
        //slow rolls the rice for dramatic effect
        slowRoll();
        //adds all the dices together.
        chuckDealer = total();
        System.out.println("Total:" + chuckDealer);

        Casino.delay();

        System.out.println("How much would you like to bet?");
        bet = scan.nextInt();

        System.out.println("Would you like to bet high or low?\n"
                + "Press H for high, or L for low");

        input = scan.next().toLowerCase().charAt(0);
        boolean pizza = true;

        while (pizza) {
            switch (input) {
                case 'h':
                    System.out.println("You chose high");
                    pizza = false;
                    break;
                case 'l':
                    System.out.println("You chose low");
                    pizza = false;
                    break;
                default:
                    System.out.println("High or Low, brother, is this your first time playing?");
            }
        }
    }

    public Integer total() {
        Integer sum = 0;
        for (Integer s : diceThrowResults ) {
            sum += s;
        }
        return sum;
    }

    public void slowRoll(){
        for(int i = 0; i < diceThrowResults.size(); i++){
            Casino.delay();
            System.out.println("Roll " + (i+1) + " Dealer rolls a :" + diceThrowResults.get(i));
        }
    }
}
//
//    if(chuckPlayer > chuckDealer && high || chuckPlayer < chuckDealer && low) {
//        System.out.println("You have won!");
//        balance += (bet*2);
//    } else
//        System.out.println("You have lost");


