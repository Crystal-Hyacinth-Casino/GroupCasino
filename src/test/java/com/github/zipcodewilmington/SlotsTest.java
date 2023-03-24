package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SlotsTest {
    @Test
    public void testAdd(){
        Casino casino = new Casino();
        CasinoAccount tim = new CasinoAccount("Tim", "Park", 10000);
        SlotsPlayer slotsPlayer = new SlotsPlayer(tim);
        casino.play(new SlotsGame(), slotsPlayer);
//        SlotsGame().add
//
//        playerList.get(0).getArcadeAccount();

    }
}
