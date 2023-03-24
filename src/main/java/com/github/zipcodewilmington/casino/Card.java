package com.github.zipcodewilmington.casino;

public class Card {
    public enum Rank{
        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING;
    }
    public enum Suit{
        HEARTS,
        DIAMONDS,
        CLUBS,
        SPADES;
    }
    private final Rank rank;
    private final Suit suit;

    Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }
    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
    public String toString(){
        return rank + " of " + suit;
    }
}
