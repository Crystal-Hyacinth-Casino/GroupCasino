package com.github.zipcodewilmington.casino.games.Roulette;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.IGamblingGame;
import com.github.zipcodewilmington.casino.PlayerInterface;

/**
 * Created by leon on 7/21/2020.
 */
public class RouletteGame implements IGamblingGame {
    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {

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
}