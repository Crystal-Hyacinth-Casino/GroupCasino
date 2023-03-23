package com.github.zipcodewilmington.casino;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dice {

    private List<Dice> diceValues;

    public Integer diceRoll(){
        Integer diceResult = 0;
        Random rand = new Random();
        return diceResult = rand.nextInt(6) + 1;
    }

    public ArrayList<Integer> diceHand(Integer numberOfDice){
        ArrayList<Integer> diceThrowResults = new ArrayList<>();
        for(int i = 0; i < numberOfDice; i++){
            diceThrowResults.add(diceRoll());
        }
        return diceThrowResults;
    }
}
