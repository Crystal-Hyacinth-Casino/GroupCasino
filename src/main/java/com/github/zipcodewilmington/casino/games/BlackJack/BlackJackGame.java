package com.github.zipcodewilmington.casino.games.BlackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.IGamblingGame;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.Card;
import com.github.zipcodewilmington.casino.games.Deck;

public class BlackJackGame implements IGamblingGame {
    List<PlayerInterface> playerList = new ArrayList<>();
    Casino casino = new Casino();
    PlayerInterface player;


    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Blackjack table, please place your initial bet.");
        System.out.println("Enter an amount: ");
        int initialBet = scanner.nextInt();

        System.out.println("Thank you. Good luck!");

        ArrayList<ArrayList<Card>> playerHands = new ArrayList<ArrayList<Card>>();
        ArrayList<Card> playerInitialHand = new ArrayList<Card>();
        playerHands.add(playerInitialHand);

        ArrayList<Card> dealerHand = new ArrayList<Card>();
        Deck deck = new Deck();
        deck.shuffle();

        //deal first two cards for initial hand
        playerHands.get(0).add(deck.draw());
        dealerHand.add(deck.draw());
        playerHands.get(0).add(deck.draw());
        dealerHand.add(deck.draw());

        //prompt for split or double
        boolean validAction = false;
        boolean hit = true;
        boolean doubleDown = false;
        System.out.println("You hand is ...");
        for (Card c : playerHands.get(0)) {
            System.out.println(c.toString());
        }

        while (!validAction) {
            System.out.println("Do you want to double or split?  Please say \"no\", \"double\", or \"split\"");
            String action = scanner.next();
            System.out.println(action);
            switch (action) {
                case "double":
                    validAction = true;
                    initialBet += initialBet;
                    playerHands.get(0).add(deck.draw());
                    hit = false;
                    break;

                case "split":
                    validAction = true;
                    ArrayList<Card> playerNewHand = new ArrayList<Card>();
                    playerNewHand.add(playerHands.get(0).remove(1));
                    playerHands.add(playerNewHand);
                    break;

                case "no":
                    validAction = true;
                    break;

                default:
                    System.out.println("Invalid response!");

            }
        }
        System.out.println("You are now playing " + playerHands.size() + " hands.");

        // prompt for hit or stay for remaining turns
        for (int i = 0; i < playerHands.size(); i++) {
            hit = true;
            while (hit && !doubleDown) {
                if (getTotal(playerHands.get(i)) > 21) {
                    hit = false;
                    break;
                }
                if (playerHands.size() > 1) {
                    System.out.println("Now dealing your hand #" + Integer.toString(i + 1));
                }
                System.out.println("You have " + getTotal(playerHands.get(i)));
                System.out.println("Do you want to hit or hold?");
                String action = scanner.next();
                if (action.equals("hold")) {
                    hit = false;
                    break;
                }
                Card newCard = deck.draw();
                playerHands.get(i).add(newCard);
                System.out.println("You drew " + newCard.toString());
            }
        }

        //dealer plays
        while (getTotal(dealerHand) < 16) {
            dealerHand.add(deck.draw());
        }
        System.out.println("Dealer has " + getTotal(dealerHand));
        System.out.println("Player has " + getTotal(playerHands.get(0)));

        //calculate winning hands
        for (int i = 0; i < playerHands.size(); i++) {
            System.out.println("The outcome for your " + i + " hand is...");
            int playerScore = getTotal(playerHands.get(i));
            int dealerScore = getTotal(dealerHand);
            if (playerScore == dealerScore && playerScore <= 21 && dealerScore <= 21) {
                System.out.println("   Push");
            } else if ((playerScore > dealerScore && playerScore <= 21) || (dealerScore > 21 && playerScore <= 21)) {
                System.out.println("   Player Wins!");
                // TODO:  award money to the player equal to the initial bet, or doubled bet
                playerList.get(0).getArcadeAccount().deposit(initialBet);
                System.out.println(playerList.get(0).getArcadeAccount().getBalance());
            } else {
                System.out.println("   Player Loses!");
                // TODO: subtract money from the player's account equal to initial bet, or doubled bet
                playerList.get(0).getArcadeAccount().remove(initialBet);
                System.out.println(playerList.get(0).getArcadeAccount().getBalance());
            }
        }

        boolean keepPlaying = true;
        while (keepPlaying) {
            System.out.println("Would you like to play again? yes/no:");
            String response = scanner.next();
            if (response.equals("yes")) {
                run();
            } else {
                casino.checkinLobby(playerList.get(0).getArcadeAccount());
                keepPlaying = false;

            }
        }
    }

    public int getTotal(ArrayList<Card> hand) {
        int total = 0;
        int numberOfAces = 0;
        for (int i = 0; i < hand.size(); i++) {
            // add each card's value to the total
            // could implement a switch statement on the card's rank, with the value assigned for each rank
            // with special handling for the ace - treat them as 11 initially, but keep track of how many there are,
            // then if the total is > 21, subtract 10 iteratively for each ace until you get under 21 or run out of aces.
            Card.Rank rank = hand.get(i).getRank();
            switch (hand.get(i).getRank()) {
                case TWO:
                    total += 2;
                    break;
                case THREE:
                    total += 3;
                    break;
                case FOUR:
                    total += 4;
                    break;
                case FIVE:
                    total += 5;
                    break;
                case SIX:
                    total += 6;
                    break;
                case SEVEN:
                    total += 7;
                    break;
                case EIGHT:
                    total += 8;
                    break;
                case NINE:
                    total += 9;
                    break;
                case TEN:
                    total += 10;
                    break;
                case JACK:
                    total += 10;
                    break;
                case QUEEN:
                    total += 10;
                    break;
                case KING:
                    total += 10;
                    break;
                case ACE:
                    total += 11;
                    numberOfAces += 1;
                    break;
            }
        }
        // now for each ace, if total > 21, subtract 10 to reflect treating the ace as 1
        for (int i=0; i < numberOfAces; i++) {
            if (total > 21) { total -= 10;}
        }
        return total;
    }

    @Override
    public boolean isWinner() {
        return false;
    }

    @Override
    public boolean bet(int bet) {
        return false;
    }

    @Override
    public int payOut(int bet) {
        return 0;
    }
    public void add(PlayerInterface player) {
        playerList.add(player);
    }

    public void remove(PlayerInterface player) {
        playerList.remove(player);
    }
}


