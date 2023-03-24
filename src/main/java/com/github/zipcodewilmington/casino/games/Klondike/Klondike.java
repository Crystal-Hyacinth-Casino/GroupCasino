package com.github.zipcodewilmington.casino.games.Klondike;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.IGamblingGame;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.Dice;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.Common;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Klondike extends Dice implements IGamblingGame {




    Scanner scan = new Scanner(System.in);
    Integer chuckPlayer;
    Integer chuckDealer;
    Integer input2 = 0;

    Integer bet;
    char input = 'z';
    List<PlayerInterface> playerList = new ArrayList<>();



    @Override
    public void run() {



        Casino casino = new Casino();

        System.out.println("Welcome to the Klondike Table");

        while (true) {



            System.out.println("Press any key, and we'll start ROLLING, pun intended");
            scan.nextLine();

            System.out.println("Shake.. shake.. shake, boom!");

            Casino.delay();

            chuckDealer = slowRoll();

            System.out.println("Total:" + chuckDealer);

            System.out.println("Please enter bet amount or type 'main' to exit to main menu: ");
            String input2 = scan.next();
            if (input2.equalsIgnoreCase("main")) {
                System.out.println("Thanks for playing!");
                casino.checkinLobby(playerList.get(0).getArcadeAccount());
                break;
            }



            System.out.println("Would you like to bet high or low?\n"
                    + "Press H for high, or L for low");

            input = scan.next().toLowerCase().charAt(0);

            boolean pizza = true;



            chuckPlayer = slowRoll2();

            System.out.println("Total:" + chuckPlayer);

            while (pizza) {
                switch (input) {
                    case 'h':
                        System.out.println("You chose high");
                        pizza = false;

                        if (chuckPlayer > chuckDealer) {
                             playerList.get(0).getArcadeAccount().deposit(Integer.parseInt(input2));
                             System.out.println("You win!");
                             System.out.println(playerList.get(0).getArcadeAccount().getBalance());
                             break;
                        } else {
                            System.out.println("You lose!");
                            playerList.get(0).getArcadeAccount().remove(Integer.parseInt(input2));
                            System.out.println(playerList.get(0).getArcadeAccount().getBalance());

                            break;
                        }
                    case 'l':
                        System.out.println("You chose low");
                        pizza = false;

                        if(chuckPlayer < chuckDealer) {
                           playerList.get(0).getArcadeAccount().deposit(Integer.parseInt(input2));
                            System.out.println("You Win!");
                            System.out.println(playerList.get(0).getArcadeAccount().getBalance());
                            break;
                        } else {
                            System.out.println("You Lose!");
                            playerList.get(0).getArcadeAccount().remove(Integer.parseInt(input2));
                            System.out.println(playerList.get(0).getArcadeAccount().getBalance());
                            break;
                        }
                    default:
                        System.out.println("High or Low, brother, is this your first time playing?");





                }
            }
            scan.nextLine();
        }
    }




    public Integer total() {
        Integer sum = 0;
        Dice diceTotal = new Dice();
        for (Integer s : diceTotal.diceThrow(5) ) {
            sum += s;
        }
        return sum;
    }

    public int slowRoll(){
        int sum = 0;
        for(int i = 0; i < 5; i++){
            Dice diceSlowRoll = new Dice();
            Common.delay();
            System.out.println(Common.red("Roll " + (i+1) + ", Dealer rolls a: " + diceSlowRoll.diceThrow(5).get(i)));
            sum+=diceSlowRoll.diceThrow(5).get(i);
        }
        return sum;
    }

    public int slowRoll2(){
        int sum = 0;
        for(int i = 0; i < 5; i++){
            Dice diceSlowRoll = new Dice();
            Common.delay();
            System.out.println(Common.green("Roll " + (i+1) + ", Player rolls a: " + diceSlowRoll.diceThrow(5).get(i)));
            sum+=diceSlowRoll.diceThrow(5).get(i);
        }
        return sum;
    }


    @Override
    public void add(PlayerInterface player) {
        playerList.add(player);
    }



    @Override
    public void remove(PlayerInterface player) {
        playerList.remove(player);
    }




    @Override
    public boolean isWinner() {
        System.out.println("You have won!");
        return true;
    }

    @Override
    public boolean bet(int bet) {
    return false;
    }

    @Override
    public int payOut(int bet) {
        return 0;
    }
}



