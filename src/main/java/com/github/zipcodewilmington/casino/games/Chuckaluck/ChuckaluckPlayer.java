package com.github.zipcodewilmington.casino.games.Chuckaluck;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class ChuckaluckPlayer extends CasinoAccount implements PlayerInterface {
    CasinoAccount casinoAccount;


    public ChuckaluckPlayer(CasinoAccount account) { super(account) ;}

    @Override
    public CasinoAccount getArcadeAccount() {
        return this;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }
}
