package com.github.zipcodewilmington.casino.games.RPS;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class RpsPlayer extends CasinoAccount implements PlayerInterface {
    public RpsPlayer(CasinoAccount casinoAccount){
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