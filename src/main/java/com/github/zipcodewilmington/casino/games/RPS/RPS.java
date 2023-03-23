package com.github.zipcodewilmington.casino.games.RPS;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RPS {

    Scanner scanner = new Scanner(System.in);

    private static final String ROCK = "rock";
    private static final String PAPER = "paper";
    private static final String SCISSORS = "scissors";

    String playerChoice;
    String dealerHand;
    boolean isPlaying;

    public void displayRules(){
        System.out.println("Welcome to Rock-Paper-Scissors!\n" +
                "Try and beat the opponent's literal hand!\n" +
                "\n" +
                "Please enter one of the following hands:\n" +
                "Type 'rock' for ROCK\n" +
                "Type: 'scissors for SCISSORS\n" +
                "Type: 'paper' for PAPER\n\n" +
                "Remember:\n" +
                "Rock beats scissors, scissors beats paper, and paper beats rock!");
    }
    public String getPlayerInput() {
        while (true){
            String playerChoice = scanner.nextLine();
            if (playerChoice.equalsIgnoreCase(ROCK)) {
                System.out.println(" _______\n" +
                        "---'   ____)\n" +
                        "      (_____)\n" +
                        "      (_____)\n" +
                        "      (____)\n" +
                        "---.__(___)");
                this.playerChoice = playerChoice;
                break;
            } else if (playerChoice.equalsIgnoreCase(PAPER)) {
                System.out.println("  _______\n" +
                        "---'   ____)____\n" +
                        "          ______)\n" +
                        "          _______)\n" +
                        "         _______)\n" +
                        "---.__________)\n");
                this.playerChoice = playerChoice;
                break;

            } else if (playerChoice.equalsIgnoreCase(SCISSORS)) {
                System.out.println("  _______\n" +
                        "---'   ____)____\n" +
                        "          ______)\n" +
                        "       __________)\n" +
                        "      (____)\n" +
                        "---.__(___)");
                this.playerChoice = playerChoice;
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

        result = hands.get(choice);
        if(result.equals("rock")){
            System.out.println(" _______\n" +
                    "---'   ____)\n" +
                    "      (_____)\n" +
                    "      (_____)\n" +
                    "      (____)\n" +
                    "---.__(___)");
        } else if(result.equals("paper")){
            System.out.println("  _______\n" +
                    "---'   ____)____\n" +
                    "          ______)\n" +
                    "          _______)\n" +
                    "         _______)\n" +
                    "---.__________)\n");
        } else if(result.equals("scissors")){
            System.out.println("  _______\n" +
                    "---'   ____)____\n" +
                    "          ______)\n" +
                    "       __________)\n" +
                    "      (____)\n" +
                    "---.__(___)");
        }
        this.dealerHand = result;
        return result;
    }
    public String getWinner(String playerChoice, String dealerChoice) {
        while(playerChoice.equalsIgnoreCase(ROCK)){
            if(dealerChoice.equals(PAPER)){
                System.out.println("Player loses! Paper covers rock!");
                return PAPER;
            } else if(dealerChoice.equals(SCISSORS)){
                System.out.println("Player wins! Rock smashes scissors!!");
                return SCISSORS;
            }
            else {
                System.out.println("Player has tied!");
                return "Player has tied!";
            }
        }
        while(playerChoice.equalsIgnoreCase(PAPER)){
            if(dealerChoice.equals(ROCK)){
                System.out.println("Player wins! Paper covers rock!");
                return PAPER;
            } else if(dealerChoice.equals(SCISSORS)){
                System.out.println("Player loses! Scissors cuts paper!");
                return SCISSORS;
            } else {
                System.out.println("Player has tied!");
                return "Player has tied!";
            }
        }
        while(playerChoice.equalsIgnoreCase(SCISSORS)){
            if(dealerChoice.equals(ROCK)){
                System.out.println("Player loses! Rock smashes scissors!");
                return ROCK;
            } else if(dealerChoice.equals(PAPER)){
                System.out.println("Player wins! Scissors cuts paper!");
                return SCISSORS;
            } else System.out.println("Player has tied!");
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
                this.isPlaying = false;
                break;
            } else {
                System.out.println("That is not a valid answer...");
            }
        }
    }
    public void play(){
        isPlaying = true;
        do {
            displayRules();
            getPlayerInput();
            getDealerHand();
            getWinner(this.playerChoice, this.dealerHand);
            playAgain();
        } while(isPlaying == true);
    }
    public static void main(String[] args) {
        RPS rps = new RPS();
        rps.play();

    }
}
