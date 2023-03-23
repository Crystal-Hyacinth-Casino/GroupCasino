package com.github.zipcodewilmington.casino;


import com.github.zipcodewilmington.casino.Card;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Deck {

    Card.Suit suit;
    Card.Rank rank;
    List<Card> cards;
    public Deck(){
        cards = new Stack<>();
        for(Card.Suit suit : suit.values()){
            for(Card.Rank rank : rank.values()){
                cards.add(new Card(rank, suit));
            }
        }
    }
    public void shuffle(){
        Collections.shuffle(cards);
    }
    public Card draw(){
        return cards.remove(0);
    }
    public int size = cards.size();
    public void printDeck() {
        for (Card card : cards) {
            card.toString();
        }
    }

}
