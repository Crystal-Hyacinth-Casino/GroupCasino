package com.github.zipcodewilmington.casino.games.RPS;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.Common;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RPS implements GameInterface {
    Scanner scanner = new Scanner(System.in);

    private static final String ROCK = "rock";
    private static final String PAPER = "paper";
    private static final String SCISSORS = "scissors";
    List<PlayerInterface> playerList = new ArrayList<>();
    Casino casino = new Casino();

    String playerChoice;
    String dealerHand;
    boolean isPlaying;

    public void displayRules(){
        System.out.println(Common.cyan("Welcome to Rock-Paper-Scissors!\n") +
                "Try and beat the opponent's literal hand!\n" +
                "\n" +
                "Please enter one of the following hands:\n" +
                Common.red("Type 'r' for ROCK\n") +
                Common.yellow("Type: 'p' for PAPER\n") +
                Common.green("Type: 's for SCISSORS\n\n") +
                Common.blue("Remember:\n" +
                        "Rock beats scissors, scissors beats paper, and paper beats rock!"));
    }

    public String getPlayerInput() {
        while (true){
            String playerChoice = scanner.nextLine();
            System.out.println(Common.green("\n==================\n" +
                    "Player throws out!\n" +
                    "=================="));
            if (playerChoice.equalsIgnoreCase(ROCK) || playerChoice.substring(0).equalsIgnoreCase("r")) {
                System.out.println(Common.red("    _______\n" +
                        "---'   ____)\n" +
                        "      (_____)\n" +
                        "      (_____)\n" +
                        "      (____)\n" +
                        "---.__(___)"));
                this.playerChoice = ROCK;
                break;
            } else if (playerChoice.equalsIgnoreCase(PAPER) || playerChoice.substring(0).equalsIgnoreCase("p")) {
                System.out.println(Common.yellow("    _______\n" +
                        "---'   ____)____\n" +
                        "          ______)\n" +
                        "          _______)\n" +
                        "         _______)\n" +
                        "---.__________)\n"));
                this.playerChoice = PAPER;
                break;

            } else if (playerChoice.equalsIgnoreCase(SCISSORS) || playerChoice.substring(0).equalsIgnoreCase("s")) {
                System.out.println(Common.green("    _______\n" +
                        "---'   ____)____\n" +
                        "          ______)\n" +
                        "       __________)\n" +
                        "      (____)\n" +
                        "---.__(___)"));
                this.playerChoice = SCISSORS;
                break;
            } else{
                System.out.println("That is not a valid option, please try again...");
            }
        }
        return playerChoice;
    }

    private String getDealerHand(){
        Random random = new Random();
        String result;
        int choice = random.nextInt(3);
        ArrayList<String> hands = new ArrayList<>();
        hands.add("rock");
        hands.add("paper");
        hands.add("scissors");

        Common.delay();
        System.out.println(Common.red("====================\n" +
                "Opponent throws out!\n" +
                "===================="));
        Common.delay(); Common.delay();
        result = hands.get(choice);
        if(result.equals("rock")){
            System.out.println(Common.red("    _______\n" +
                    "---'   ____)\n" +
                    "      (_____)\n" +
                    "      (_____)\n" +
                    "      (____)\n" +
                    "---.__(___)"));
        } else if(result.equals("paper")){
            System.out.println(Common.yellow("    _______\n" +
                    "---'   ____)____\n" +
                    "          ______)\n" +
                    "          _______)\n" +
                    "         _______)\n" +
                    "---.__________)\n"));
        } else if(result.equals("scissors")){
            System.out.println(Common.green("    _______\n" +
                    "---'   ____)____\n" +
                    "          ______)\n" +
                    "       __________)\n" +
                    "      (____)\n" +
                    "---.__(___)"));
        }
        this.dealerHand = result;
        return result;
    }
    public String getWinner(String playerChoice, String dealerChoice) {
        while(playerChoice.equalsIgnoreCase(ROCK)){
            if(dealerChoice.equals(PAPER)){
                System.out.println(Common.red("================================\n" +
                        "Player loses! Paper covers rock!\n" +
                        "================================"));
                return PAPER;
            } else if(dealerChoice.equals(SCISSORS)){
                System.out.println(Common.green("===================================\n" +
                        "Player wins! Rock smashes scissors!\n" +
                        "==================================="));
                return SCISSORS;
            }
            else {
                System.out.println(Common.yellow("================\n" +
                        "Player has tied!\n" +
                        "================"));
                return "Player has tied!";
            }
        }
        while(playerChoice.equalsIgnoreCase(PAPER)){
            if(dealerChoice.equals(ROCK)){
                System.out.println(Common.green("===============================\n" +
                        "Player wins! Paper covers rock!\n" +
                        "==============================="));
                return PAPER;
            } else if(dealerChoice.equals(SCISSORS)){
                System.out.println(Common.red("==================================\n" +
                        "Player loses! Scissors cuts paper!\n" +
                        "=================================="));
                return SCISSORS;
            } else {
                System.out.println(Common.yellow("================\n" +
                        "Player has tied!\n" +
                        "================"));
                return "Player has tied!";
            }
        }
        while(playerChoice.equalsIgnoreCase(SCISSORS)){
            if(dealerChoice.equals(ROCK)){
                System.out.println(Common.red("=====================================\n" +
                        "Player loses! Rock smashes scissors!\n" +
                        "====================================="));
                return ROCK;
            } else if(dealerChoice.equals(PAPER)){
                System.out.println(Common.green("=================================\n" +
                        "Player wins! Scissors cuts paper!\n" +
                        "================================="));
                return SCISSORS;
            } else {
                System.out.println(Common.yellow("================\n" +
                        "Player has tied!\n" +
                        "================"));
                return "Player has tied!";
            }
        }
        return null;
    }

    public void playAgain(){
        while(true) {
            System.out.println("Would you like to play again y/n?");
            String decision = scanner.nextLine();
            if (decision.equals("y")) {
                break;
            } else if (decision.equals("n")) {
                casino.checkinLobby(playerList.get(0).getArcadeAccount());
                break;
            } else {
                System.out.println("That is not a valid answer...");
            }
        }
    }

    @Override
    public void add(PlayerInterface player) {
        playerList.add(player);
    }

    @Override
        public void remove(PlayerInterface player) {
            playerList.remove(player);
        }

    public void run(){
        isPlaying = true;
        do {
            displayRules();
            getPlayerInput();
            getDealerHand();
            getWinner(this.playerChoice, this.dealerHand);
            playAgain();
        } while(isPlaying == true);
    }
}