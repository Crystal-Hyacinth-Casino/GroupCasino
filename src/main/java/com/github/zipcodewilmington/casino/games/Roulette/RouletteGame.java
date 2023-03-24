package com.github.zipcodewilmington.casino.games.Roulette;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.IGamblingGame;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */
public class RouletteGame implements IGamblingGame {
    List<PlayerInterface> playerList = new ArrayList<>();
    int bet;
    int betType;
    int betNumber;
    int spinResult;
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    Casino casino = new Casino();

    public RouletteGame() {
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
            if (playerList.get(0).getArcadeAccount().getBalance() == 0) {
                System.out.println("You're a brokie. What colors your Bugatti... returning to main menu.");
                casino.checkinLobby(playerList.get(0).getArcadeAccount());
            }
            // Ask for bet amount
            System.out.println("Please enter bet amount or type 'quit' to exit: ");
            String input = sc.next();
            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Thanks for playing!");
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
            int currentBalance = playerList.get(0).getArcadeAccount().getBalance();
            playerList.get(0).getArcadeAccount().setBalance(currentBalance - bet);
            currentBalance = playerList.get(0).getArcadeAccount().getBalance();

            // Ask for bet type
            System.out.println("Choose your bet type:\n1. Red\n2. Black\n3. Single Number (0-36)\n4. Lower Third\n5. Middle Third\n6. Upper Third\n7. Lower Half\n8. Upper Half");
            betType = sc.nextInt();

            if (betType == 3) {
                System.out.println("Enter the number you want to bet on (0-36):");
                betNumber = sc.nextInt();
            }
            spinResult = spinWheel();

            // Check the result
            boolean isWinner = checkResult(spinResult);
            int payOutAmount = payOut(bet);

            if (isWinner) {
                System.out.println("Congratulations, you won!");
                playerList.get(0).getArcadeAccount().setBalance(currentBalance + payOutAmount);
            } else {
                System.out.println("Sorry, you lost.");
                playerList.get(0).getArcadeAccount().setBalance(currentBalance);
            }
            System.out.println(playerList.get(0).getArcadeAccount().getBalance());
        }
    }


    private int spinWheel() {
        return random.nextInt(37); // Returns a number between 0 and 36 (inclusive)
    }

    private boolean checkResult(int spinResult) {
        switch (betType) {
            case 1: // Red
                return spinResult != 0 && spinResult % 2 == 1;
            case 2: // Black
                return spinResult != 0 && spinResult % 2 == 0;
            case 3: // Single number
                return spinResult == betNumber;
            case 4: // Lower third
                return lowerThird(spinResult);
            case 5: // Middle third
                return middleThird(spinResult);
            case 6: // Upper third
                return upperThird(spinResult);
            case 7: // Lower half
                return lowerHalf(spinResult);
            case 8: // Upper half
                return upperHalf(spinResult);
            default:
                return false;
        }
    }

    public boolean lowerThird(int spinResult) {
        return spinResult >= 1 && spinResult <= 12;
    }

    public boolean middleThird(int spinResult) {
        return spinResult >= 13 && spinResult <= 24;
    }

    public boolean upperThird(int spinResult) {
        return spinResult >= 25 && spinResult <= 36;
    }

    public boolean lowerHalf(int spinResult) {
        return spinResult >= 1 && spinResult <= 18;
    }

    public boolean upperHalf(int spinResult) {
        return spinResult >= 19 && spinResult <= 36;
    }

    @Override
    public boolean isWinner() {
        return checkResult(spinResult);
    }

    @Override
    public boolean bet(int betAmount) {
        if (playerList.get(0).getArcadeAccount().getBalance() < betAmount){
            return true;
        }
        return false;
    }

    public int payOut(int bet) {
        int payOutAmount = 0;
        if (isWinner()) {
            switch (betType)  {
                case 1:// Red
                    payOutAmount = bet * 2;
                    break;
                case 2: // Black
                    payOutAmount = bet * 2;
                    break;
                case 3: // Single number
                    payOutAmount = bet * 36;
                    break;
                case 4: // Lower third
                    payOutAmount = bet * 3;
                    break;
                case 5: // Middle third
                    payOutAmount = bet * 3;
                    break;
                case 6: // Upper third
                    payOutAmount = bet * 3;
                    break;
                case 7: // Lower half
                    payOutAmount = bet * 2;
                    break;
                case 8: // Upper half
                    payOutAmount = bet * 2;
                    break;
                default:
                    payOutAmount = 0;
                    break;
            }
            if (payOutAmount == 0){
                playerList.get(0).getArcadeAccount().getBalance();
            }
            int currentBalance = playerList.get(0).getArcadeAccount().getBalance();
            playerList.get(0).getArcadeAccount().setBalance(currentBalance + payOutAmount);
        }
        return payOutAmount;
    }
}