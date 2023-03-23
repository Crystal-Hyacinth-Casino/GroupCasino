package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer extends CasinoAccount implements PlayerInterface {
    CasinoAccount casinoAccount;

    public SlotsPlayer(CasinoAccount casinoAccount){
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