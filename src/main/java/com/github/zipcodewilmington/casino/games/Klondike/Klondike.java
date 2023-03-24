package com.github.zipcodewilmington.casino.games.Klondike;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.IGamblingGame;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.Dice;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Klondike extends Dice implements IGamblingGame {


    List<KlondikePlayer> klondikePlayer = new ArrayList<>();

    Scanner scan = new Scanner(System.in);
    Integer chuckPlayer;
    Integer chuckDealer;
    Integer input2 = 0;

    Integer bet;
    char input = 'z';

    @Override
    public void run() {

    }

    public void playGame(CasinoAccount account) {
        KlondikePlayer klondike = new KlondikePlayer(account);
        System.out.println(klondike.getArcadeAccount());


        CasinoAccount hiep = klondike.getArcadeAccount();


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
                casino.checkinLobby(hiep);
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
                             hiep.deposit(Integer.parseInt(input2));
                             System.out.println("You win!");
                             System.out.println(hiep.getBalance());
                             break;
                        } else {
                            System.out.println("You lose!");
                            hiep.remove(Integer.parseInt(input2));
                            System.out.println(hiep.getBalance());

                            break;
                        }
                    case 'l':
                        System.out.println("You chose low");
                        pizza = false;

                        if(chuckPlayer < chuckDealer) {
                           hiep.deposit(Integer.parseInt(input2));
                            System.out.println("You Win!");
                            System.out.println(hiep.getBalance());
                            break;
                        } else {
                            System.out.println("You Lose!");
                            hiep.remove(Integer.parseInt(input2));
                            System.out.println(hiep.getBalance());
                            break;
                        }
                    default:
                        System.out.println("High or Low, brother, is this your first time playing?");





                }
            }
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
            Casino.delay();
            System.out.println("Roll " + (i+1) + " Dealer rolls a :" + diceSlowRoll.diceThrow(5).get(i));
            sum+=diceSlowRoll.diceThrow(5).get(i);
        }
        return sum;
    }

    public int slowRoll2(){
        int sum = 0;
        for(int i = 0; i < 5; i++){
            Dice diceSlowRoll = new Dice();
            Casino.delay();
            System.out.println("Roll " + (i+1) + " Player rolls a :" + diceSlowRoll.diceThrow(5).get(i));
            sum+=diceSlowRoll.diceThrow(5).get(i);
        }
        return sum;
    }


    @Override
    public void add(PlayerInterface player) {
        klondikePlayer.add((KlondikePlayer) player);

    }

    @Override
    public void remove(PlayerInterface player) {
        klondikePlayer.remove(player);

    }




    @Override
    public boolean isWinner() {
        System.out.println("You have won!");
        return true;
    }

    @Override
    public int bet(int bet) {
    return 0;
    }

    @Override
    public int payOut(int bet) {
        return 0;
    }
}



