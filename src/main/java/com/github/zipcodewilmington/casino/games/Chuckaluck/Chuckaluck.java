package com.github.zipcodewilmington.casino.games.Chuckaluck;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.IGamblingGame;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.Dice;
import com.github.zipcodewilmington.casino.games.Klondike.Klondike;
import com.github.zipcodewilmington.casino.games.Klondike.KlondikePlayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Chuckaluck extends Dice implements IGamblingGame {

    static Scanner scanner = new Scanner(System.in);
    static Random rand = new Random();
    ArrayList<Integer> playerRoll = new ArrayList<>();
    Dice dice = new Dice();


   public void playGame(CasinoAccount account){

       ChuckaluckPlayer chuckaluck = new ChuckaluckPlayer(account);
       System.out.println(chuckaluck.getArcadeAccount());

       CasinoAccount hiep = chuckaluck.getArcadeAccount();

       Casino casino = new Casino();


        System.out.println("Welcome to Chuck Luck");
        System.out.println("Please put your wager down, enter amount ");
        int bet = scanner.nextInt();
        System.out.println(hiep.getBalance());
        System.out.println("Thank you for your wager");

        System.out.println("Please choose a number between 1,2,3,4,5,6");
        int number = scanner.nextInt();
        System.out.println("You choose number" + number);

        int[] dice = new int[3];

        for (int i = 0; i < 3; i++) {
            dice[i] = rand.nextInt(6) + 1;
        }

        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (dice[i] == number) {
                count++;
            }
        }

        int payout = 0;
        if (count == 1) {
            payout = 1 * bet;
            hiep.deposit(payout);
            System.out.println(hiep.getBalance());

        } else if (count == 2) {
            payout = 2 * bet;
            hiep.deposit(payout);
            System.out.println(hiep.getBalance());

        } else if (count == 3) {
            payout = 10 * bet;
            hiep.deposit(payout);
            System.out.println(hiep.getBalance());
        } else {
            hiep.remove(bet);
            System.out.println(hiep.getBalance());
        }

        System.out.println(Arrays.toString(dice) + "dice equal your guess.");
        System.out.println("Payout:" + payout);

        boolean keepPlaying = true;
        while (keepPlaying) {
            System.out.println("Would you like to play again? yes/no:");
            String response = scanner.next();
            if (response.equals("yes")) {
                playGame(hiep);
            } else {
                keepPlaying = false;
                casino.checkinLobby(hiep);
            }
        }
    }



    public void displayRoll() {
        for (int i = 0; i < 3; i++) {
            playerRoll.add(rand.nextInt(6) + 1);
        }
    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {

    }

    @Override
    public boolean isWinner() {
        return false;
    }

    @Override
    public int bet(int bet) {
        return 0;
    }

    @Override
    public int payOut(int bet) {
        return 0;
    }
    // this is creating three random dice rolls (set)

}
