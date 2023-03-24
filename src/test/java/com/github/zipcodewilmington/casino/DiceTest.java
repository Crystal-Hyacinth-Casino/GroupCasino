package com.github.zipcodewilmington.casino;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    @Test
    void testDiceRoll() {
        Dice dice = new Dice();
        int result = 0;
        for(int i = 0; i < 1000; i++){
            result = dice.diceRoll();
        }
        Assert.assertEquals(true, result < 7 && result > 0);
    }

    @Test
    void TestDiceHand() {
        ArrayList<Integer> results;
        Dice dice = new Dice();
        results = dice.diceHand(3);

        Assert.assertEquals(3, results.size());

    }

    @Test
    void TestDiceThrow(){
        Dice dice = new Dice();
        Integer sum = 0;

        for(int i = 0; i < 1000; i++){
            sum += dice.diceThrowResults(2);
            if(sum > 12000){
                fail();
                System.out.println("Sum value exceeded max possible");
            } else if(sum == 0){
                fail();
                System.out.println("Integers not adding");
            }

        }

    }
}