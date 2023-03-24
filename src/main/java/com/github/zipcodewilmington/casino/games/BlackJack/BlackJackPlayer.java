package com.github.zipcodewilmington.casino.games.BlackJack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class BlackJackPlayer extends CasinoAccount implements PlayerInterface {
    CasinoAccount casinoAccount;

    public BlackJackPlayer(CasinoAccount account) { super(account) ;}

    @Override
    public CasinoAccount getArcadeAccount() {
        return this;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }
}
