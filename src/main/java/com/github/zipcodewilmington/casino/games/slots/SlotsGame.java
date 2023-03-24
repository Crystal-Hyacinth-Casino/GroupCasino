package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.IGamblingGame;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame implements IGamblingGame {
    List<PlayerInterface> playerList = new ArrayList<>();
    int bet;
    ArrayList<String> slotThangs = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    List<String> lastSpinResults;

    public SlotsGame() {
        slotThangs.add("lemons");
        slotThangs.add("lemons");
        slotThangs.add("lemons");
        slotThangs.add("seven");
        slotThangs.add("bars");
        slotThangs.add("bars");
        slotThangs.add("apples");
        slotThangs.add("apples");
        slotThangs.add("apples");
        slotThangs.add("banana");
        slotThangs.add("banana");
        slotThangs.add("banana");
        slotThangs.add("cherry");
        slotThangs.add("cherry");
        slotThangs.add("cherry");
        slotThangs.add("orange");
        slotThangs.add("orange");
        slotThangs.add("orange");
    }

    public int payOutMultiplier(String result) {
        if (result.equals("lemons")) {
            return 2;
        } else if (result.equals("seven")) {
            return 500;
        } else if (result.equals("bars")) {
            return 2;
        } else if (result.equals("apples")) {
            return 2;
        } else if (result.equals("banana")) {
            return 2;
        } else if (result.equals("cherry")) {
            return 2;
        } else if (result.equals("orange")) {
            return 2;
        }
        return 1;
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
    public void run() {
        while (true) {
            if (playerList.get(0).getArcadeAccount().getBalance() == 0){
                System.out.println("You're a brokie. What colors your Bugatti... returning to main menu.");
                Casino casino = new Casino();
                casino.checkinLobby(playerList.get(0).getArcadeAccount());
            }
            System.out.println("Please enter bet amount or type 'quit' to exit: ");
            String input = sc.next();
            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Thanks for playing!");
                Casino casino = new Casino();
                casino.checkinLobby(playerList.get(0).getArcadeAccount());
            }
            try {
                bet = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please try again.");
                continue;
            }
            if (this.bet(bet)){
                System.out.println("You have insufficient funds. Current balance: " + playerList.get(0).getArcadeAccount().getBalance());
                continue;
            }

            lastSpinResults = pullLever();
            System.out.println("The results are: " + lastSpinResults);
            if (this.isWinner()) {
                System.out.println("Congratulations, you won!");
            } else {
                System.out.println("Sorry, you lost.");
            }
            int currentBalance = playerList.get(0).getArcadeAccount().getBalance();
            playerList.get(0).getArcadeAccount().setBalance(currentBalance + this.payOut(bet));
            System.out.println(playerList.get(0).getArcadeAccount().getBalance() + " is your balance currently.");
        }
    }

    private String spin() {
        int index = random.nextInt(slotThangs.size());
        return slotThangs.get(index);
    }

    private List<String> pullLever() {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            results.add(spin());
        }
        return results;
    }

    public boolean isWinner() {
        if (lastSpinResults == null || lastSpinResults.isEmpty()) {
            return false;
        }
        String firstSymbol = lastSpinResults.get(0);
        for (String symbol : lastSpinResults) {
            if (!symbol.equals(firstSymbol)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean bet(int betAmount) {
        if (playerList.get(0).getArcadeAccount().getBalance() < betAmount){
            return true;
        }
        return false;
    }

    @Override
    public int payOut(int bet) {
        lastSpinResults = pullLever();
        if (this.isWinner()) {
            return bet * payOutMultiplier(lastSpinResults.get(0));
        } else {
            return -bet;
        }
    }
}