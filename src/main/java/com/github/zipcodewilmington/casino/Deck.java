package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.casino.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Deck {
    Stack<Card> cards;
    public Deck() {
         cards = new Stack<>();
         System.out.println("About to add cards.");
         for(Card.Suit suit : Card.Suit.values()){
            for(Card.Rank rank : Card.Rank.values()){
                cards.push(new Card(rank, suit));
            }
         }
    }
    public void shuffle(){
        Collections.shuffle(cards);
    }
    public Card draw(){
        return cards.pop();
    }

    public void printDeck() {
        for (Card card : cards) {
            card.toString();
        }
    }
    public static void main(String[] args) {
        System.out.println("Creating a deck...");
        Deck deck = new Deck();
    }
}
