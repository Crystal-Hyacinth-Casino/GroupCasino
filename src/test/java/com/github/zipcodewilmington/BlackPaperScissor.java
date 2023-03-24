package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.BlackJack.BlackJackGame;
import com.github.zipcodewilmington.casino.games.Card;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BlackPaperScissor {
    @Test
    public void testGetTotal() {
        //given
        ArrayList<Card> hand1 = new ArrayList<>();
        Card.Suit suit1 = Card.Suit.HEARTS;
        Card.Rank rank1 = Card.Rank.ACE;
        Card.Suit suit2 = Card.Suit.DIAMONDS;
        Card.Rank rank2 = Card.Rank.TEN;

        //when

        hand1.add(new Card(rank1, suit1));
        hand1.add(new Card(rank2, suit2));

        //then

        BlackJackGame game = new BlackJackGame();
        Assert.assertEquals(21, game.getTotal(hand1));
    }

}
