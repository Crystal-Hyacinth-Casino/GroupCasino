package com.github.zipcodewilmington.casino;

import java.util.List;

public interface IGamblingGame extends GameInterface{

    boolean isWinner();

    int bet(int bet);

    int payOut(int bet);
}
