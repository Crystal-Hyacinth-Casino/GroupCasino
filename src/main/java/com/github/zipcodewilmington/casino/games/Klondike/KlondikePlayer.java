package com.github.zipcodewilmington.casino.games.Klondike;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class KlondikePlayer extends CasinoAccount implements PlayerInterface {
    CasinoAccount casinoAccount;

    public KlondikePlayer(CasinoAccount casinoAccount){

        super(casinoAccount);
    }

    @Override
    public CasinoAccount getArcadeAccount() {

        return this;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }
}