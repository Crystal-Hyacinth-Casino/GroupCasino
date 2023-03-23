package com.github.zipcodewilmington.casino.games.slots;

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
    List<PlayerInterface> slotPlayer = new ArrayList<>();
    int bet;
    ArrayList<String> slotThangs = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    List<String> lastSpinResults;

    public SlotsGame() {
        slotThangs.add("lemons");
        slotThangs.add("seven");
        slotThangs.add("bars");
        slotThangs.add("apples");
        slotThangs.add("banana");
        slotThangs.add("cherry");
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
        slotPlayer.add(player);
    }

    @Override
    public void remove(PlayerInterface player) {
        slotPlayer.remove(player);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Please enter bet amount or type 'quit' to exit: ");
            String input = sc.next();
            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Thanks for playing!");
                break;
            }

            try {
                bet = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please try again.");
                continue;
            }

            lastSpinResults = pullLever();
            System.out.println("The results are: " + lastSpinResults);
            if (isWinner()) {
                System.out.println("Congratulations, you won!");
            } else {
                System.out.println("Sorry, you lost.");
            }
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
    public int bet(int currentBalance) {
        IOConsole console = new IOConsole(AnsiColor.BLUE);
        int balance = console.getIntegerInput("Enter how much you'd like to bet: ");
        if (balance >= currentBalance){
            return currentBalance;
        }
        return balance;
    }

    @Override
    public int payOut(int bet) {
        lastSpinResults = pullLever();
        if (isWinner()) {
            return bet * payOutMultiplier(lastSpinResults.get(0));
        } else {
            return -bet;
        }
    }
}