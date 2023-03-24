package com.github.zipcodewilmington.casino;

import java.util.List;

public interface IGamblingGame extends GameInterface{

    boolean isWinner();

    boolean bet(int bet);

    int payOut(int bet);
}
