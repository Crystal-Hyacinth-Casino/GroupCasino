package com.github.zipcodewilmington.casino.games;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Dice {
    private List<Dice> diceValues;
    protected ArrayList<Integer> diceThrowResults = new ArrayList<>();

    public Integer diceRoll(){
        Integer diceResult = 0;
        Random rand = new Random();
        return diceResult = rand.nextInt(6) + 1;
    }
    public ArrayList<Integer> diceThrow(Integer numberOfDice){
        for(int i = 0; i < numberOfDice; i++)
        {
            diceThrowResults.add(diceRoll());
        }
        return diceThrowResults;
    }
}