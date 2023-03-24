package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.RPS.RPS;
import org.junit.Assert;
import org.junit.Test;

public class RpsTest {
    RPS rps = new RPS();
    @Test
    public void getWinnerRock() {
        //Given

        String playerChoice = "rock";
        String dealerChoice = "scissors";

        //Then
        Assert.assertEquals("scissors", rps.getWinner(playerChoice, dealerChoice) );


    }
    @Test
    public void getWinnerPaper() {
        String playerChoice = "paper";
        String dealerChoice = "scissors";

        //Then
        Assert.assertEquals("scissors", rps.getWinner(playerChoice, dealerChoice) );


    }
    @Test
    public void getWinnerScissors() {
        String playerChoice = "scissors";
        String dealerChoice = "paper";

        //Then
        Assert.assertEquals("scissors", rps.getWinner(playerChoice, dealerChoice) );


    }
}

