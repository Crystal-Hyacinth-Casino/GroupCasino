package com.github.zipcodewilmington.casino.games.ChuckaLuck;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class ChuckaLuckPlayer extends CasinoAccount implements PlayerInterface {
    CasinoAccount casinoAccount;

    public ChuckaLuckPlayer(CasinoAccount casinoAccount){

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