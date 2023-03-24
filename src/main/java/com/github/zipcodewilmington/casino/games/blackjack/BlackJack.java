package com.github.zipcodewilmington.casino.games.blackjack;

import java.util.ArrayList;
import java.util.Scanner;
import com.github.zipcodewilmington.casino.Card;
import com.github.zipcodewilmington.casino.Deck;

public class BlackJack {

    public void playGame() {
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

        //deal first two cards for initial hand
        playerHands.get(0).add(deck.draw());
        dealerHand.add(deck.draw());
        playerHands.get(0).add(deck.draw());
        dealerHand.add(deck.draw());

        //prompt for split or double
        boolean validAction = false;
        boolean hit = true;
        while (validAction == false) {
            System.out.println("Do you want to double or split?  Please say \"no\", \"double\", or \"split\"");
            String action = scanner.next();
            switch (action) {
                case "double":
                    validAction = true;
                    initialBet += initialBet;
                    playerHands.get(0).add(deck.draw());
                    hit = false;

                case "split":
                    validAction = true;
                    ArrayList<Card> playerNewHand = new ArrayList<Card>();
                    playerNewHand.add(playerHands.get(0).remove(1));
                    playerHands.add(playerNewHand);

                case "no":
                    validAction = true;

                default:
                    System.out.println("Invalid response!");

            }
        }

        // prompt for hit or stay for remaining turns
        for (int i = 0; i < playerHands.size(); i++) {
            while (hit == true) {
                playerHands.get(i).add(deck.draw());
                if (getTotal(playerHands.get(i)) > 21) {
                    hit = false;
                    break;
                }
                if (playerHands.size() > 1) { System.out.println("Now dealing your hand #"+Integer.toString(i+1));}
                System.out.println("Do you want to hit or hold?");
                String action = scanner.next();
                if (action.equals("hold")) {
                    hit = false;
                }
            }
        }

        //dealer plays
        while (getTotal(dealerHand) < 16) {
            dealerHand.add(deck.draw());
        }

        //calculate winning hands
        for (int i = 0; i < playerHands.size(); i++) {
            String outcome;
            if (getTotal(playerHands.get(i)) == getTotal(dealerHand)) {
                outcome = "Push";
            } else if (getTotal(playerHands.get(i)) > getTotal(dealerHand)) {
                outcome = "Player Wins!";
                // TODO:  award money to the player equal to the initial bet, or doubled bet
            } else {
                outcome = "Player Loses!";
                // TODO: subtract money from the player's account equal to initial bet, or doubled bet
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
                case THREE:
                    total += 3;
                case FOUR:
                    total += 4;
                case FIVE:
                    total += 5;
                case SIX:
                    total += 6;
                case SEVEN:
                    total += 7;
                case EIGHT:
                    total += 8;
                case NINE:
                    total += 9;
                case TEN:
                    total += 10;
                case JACK:
                    total += 10;
                case QUEEN:
                    total += 10;
                case KING:
                    total += 10;
                case ACE:
                    total += 11;
                    numberOfAces += 1;
            }
        }
            // now for each ace, if total > 21, subtract 10 to reflect treating the ace as 1
        for (int i=0; i < numberOfAces; i++) {
            if (total > 21) { total -= 10;}
        }
        return total;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BlackJack game = new BlackJack();
        game.playGame();
        boolean keepPlaying = true;
        while (keepPlaying == true) {
            System.out.println("Would you like to play again? yes/no:");
            String response = scanner.next();
            if (response.equals("yes")) {
                game.playGame();
            } else {
                keepPlaying = false;
            }
        }
    }
}




